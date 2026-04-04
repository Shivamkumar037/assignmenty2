package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.StopRequest;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.exception.StopNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.StopRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.RouteRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.StopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StopServiceImpl implements StopService {

    private final StopRepo  stopRepo;
    private final RouteRepo  routeRepo;

    @Override
    public List<Stop> getAllStops(Integer id) {
        List<Stop > stops=stopRepo.findAllByRouteid(id);
        if(stops.isEmpty()){
            throw  new StopNotFoundException("stop nho Found ");
        }


        return stops;
    }

    @Override
    public Stop getStopById(Integer id) {
        Stop stop = stopRepo.findById(id).orElseThrow(()-> new StopNotFoundException("Stop not found "));

        return stop;
    }

    @Override
    public Stop createStop(StopRequest stopRequest) {
        Route route = routeRepo.findById(stopRequest.getRouteid()).orElseThrow(()-> new StopNotFoundException("Stop Not Found Exception"));
        Stop stop = new Stop();
        stop.setStopName(stopRequest.getStopname());
        stop.setDistanceFromSource(stopRequest.getDistance());
        stop.setRoute(route);
       return stopRepo.save(stop);


    }



    @Override
    public  void deleteStop(Integer id) {
        Stop stop = getStopById(id);
        stopRepo.delete(stop);

    }
}
