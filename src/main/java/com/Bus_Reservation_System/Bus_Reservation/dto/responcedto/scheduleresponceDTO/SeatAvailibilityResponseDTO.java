package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatAvailibilityResponseDTO {

    private Integer bus_availbility_id;

    private boolean status;

    private Integer seat_id;

    private Integer schedule_id;
}