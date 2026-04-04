package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusScheduleRequest {
    private Day travelDay;
    private LocalDate travelDate;
    private LocalTime starting;
    private LocalTime ending;
    private double totalHourse;
    private Integer busid;
    private Integer routeid;
}
