package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopRequest {

    private  Integer routeid;
    private String stopname;
    private double distance;
}
