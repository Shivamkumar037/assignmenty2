package com.Bus_Reservation_System.Bus_Reservation.service.structer;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.StopRequest;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;

import java.util.List;

public interface StopService {
    List<Stop> getAllStops(Integer id);
    Stop getStopById(Integer id);
    Stop createStop(StopRequest stopRequest);
    void deleteStop(Integer id );
}
