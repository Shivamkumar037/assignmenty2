package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.schedulerequestDTO.SeatRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO.SeatResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.Seat;
import com.Bus_Reservation_System.Bus_Reservation.exception.BusNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.exception.SeatNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.BookingRepo.BookingRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.BusRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.Schrdule.BusScheduleRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.Schrdule.SeatRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepo seatRepo;
    private final BusRepo busRepo;
    private final BusScheduleRepo busSchedule;
    private  final BookingRepo bookingRepo;

    @Override
    @Transactional
    public SeatResponseDTO addSeatToBus(SeatRequestDTO request) {
        Seat seat = requestMapping(request, new Seat());
        return responseMapping(seatRepo.save(seat));
    }

    @Override
    @Transactional
    public SeatResponseDTO updateSeatDetails(Integer seatId, SeatRequestDTO request) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException("Seat Not Found"));

        return responseMapping(seatRepo.save(requestMapping(request, seat)));
    }

    @Override
    public SeatResponseDTO getSeatById(Integer seatId) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException("Seat Not Found"));
        return responseMapping(seat);
    }

    @Override
    public List<SeatResponseDTO> getSeatsByBusId(Integer busId) {
        List<Seat> seats = seatRepo.findAllByBus_BusId(busId);
        return seats.stream().map(this::responseMapping).toList();
    }

    @Override
    @Transactional
    public void deleteSeat(Integer seatId) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException("Seat Not Found"));
        seatRepo.delete(seat);
    }



    @Override
    public Integer getAvailableSeatsByBusId(Integer busId) {
        Bus bus= busRepo.findById(busId).orElseThrow(()-> new BusNotFoundException(" bus not found"));
       BusSchedule busSchedule1=busSchedule.findByBus(bus).orElseThrow(()-> new BusNotFoundException("Bus Not FOund"));

        List<Booking> bookings=bookingRepo.findAllByBusschedule(busSchedule1);

        if(bus.getTotal_seat()>=bookings.size()){
            return bus.getTotal_seat()-bookings.size();
        }else {
            return 0;
        }

    }

    @Override
    public boolean isSeatAvailable(Integer seatId, Integer scheduleId) {
        return true;
    }

    @Override
    public List<SeatResponseDTO> addBulkSeats(List<SeatRequestDTO> requests) {

        List<Seat> seats = requests.stream()
                .map(req -> requestMapping(req, new Seat()))
                .toList();

        return seatRepo.saveAll(seats).stream()
                .map(this::responseMapping)
                .toList();
    }

  public Seat requestMapping(SeatRequestDTO dto, Seat seat) {
        if (dto.getSeat_no() != null) {
            seat.setSeat_no(dto.getSeat_no());
        }
        if (dto.getSeat_type() != null) {
            seat.setSeat_type(dto.getSeat_type());
        }
        if (dto.getBus_id() != null) {
            Bus bus = busRepo.findById(dto.getBus_id())
                    .orElseThrow(() -> new BusNotFoundException("Bus Not Found with ID: " + dto.getBus_id()));
            seat.setBus(bus);
        }
        return seat;
    }

    private SeatResponseDTO responseMapping(Seat seat) {
        SeatResponseDTO dto = new SeatResponseDTO();
        dto.setSeat_id(seat.getSeat_id());
        dto.setSeat_no(seat.getSeat_no());
        dto.setSeat_type(seat.getSeat_type());
        if (seat.getBus() != null) {
            dto.setBus_id(seat.getBus().getBus_id());
        }
        return dto;
    }
}