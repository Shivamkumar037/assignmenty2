package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.BusScheduleRequest;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.BusScheduleResponce;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import com.Bus_Reservation_System.Bus_Reservation.exception.BusNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.BusRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.RouteRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.sechedule.BusScheduleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BusScheduleServiceImpl {

    private final BusRepo busRepo;
    private final RouteRepo routeRepo;
    private final BusScheduleRepo busScheduleRepo;

    public BusScheduleResponce createSchedule(BusScheduleRequest busScheduleRequest) {
        Bus bus = busRepo.findById(busScheduleRequest.getBusid())
                .orElseThrow(() -> new BusNotFoundException("Bus Not Found"));
        Route route = routeRepo.findById(busScheduleRequest.getRouteid())
                .orElseThrow(() -> new RuntimeException("Route Not Found"));

        BusSchedule busSchedule = new BusSchedule();
        busSchedule = scheduleMapper(busScheduleRequest, busSchedule, bus, route);
        busSchedule = busScheduleRepo.save(busSchedule);

        return responseMapper(busSchedule);
    }

    public BusScheduleResponce updateSchedule(Integer id, BusScheduleRequest busScheduleRequest) {
        BusSchedule busSchedule = busScheduleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule Not Found"));

        Bus bus = busRepo.findById(busScheduleRequest.getBusid())
                .orElseThrow(() -> new BusNotFoundException("Bus Not Found"));
        Route route = routeRepo.findById(busScheduleRequest.getRouteid())
                .orElseThrow(() -> new RuntimeException("Route Not Found"));

        busSchedule = scheduleMapper(busScheduleRequest, busSchedule, bus, route);
        busSchedule = busScheduleRepo.save(busSchedule);

        return responseMapper(busSchedule);
    }

    public void deleteSchedule(Integer id) {
        BusSchedule busSchedule = busScheduleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule Not Found"));
        busScheduleRepo.delete(busSchedule);
    }

    public BusScheduleResponce getSchedule(Integer id) {
        BusSchedule busSchedule = busScheduleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule Not Found"));
        return responseMapper(busSchedule);
    }

    public List<BusScheduleResponce> getAllSchedules(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        Page<BusSchedule> schedules = busScheduleRepo.findAll(pageable);
        return schedules.getContent().stream().map(this::responseMapper).toList();
    }

    private BusSchedule scheduleMapper(BusScheduleRequest request, BusSchedule entity, Bus bus, Route route) {
        entity.setBus(bus);
        entity.setRoute(route);
        entity.setTravelDate(request.getTravelDate());
        entity.setStarting(request.getStarting());
        entity.setEnding(request.getEnding());
        entity.setTotalHourse(request.getTotalHourse());
        return entity;
    }

    private BusScheduleResponce responseMapper(BusSchedule entity) {
        BusScheduleResponce response = new BusScheduleResponce();
        response.setId(entity.getId());
        response.setStarting(entity.getStarting());
        response.setEnding(entity.getEnding());
        response.setTravelDate(entity.getTravelDate());
        if (entity.getBus() != null) {
            response.setBusid(entity.getBus().getId());
        }
        if (entity.getRoute() != null) {
            response.setRouteid(entity.getRoute().getId());
        }
        return response;
    }
}