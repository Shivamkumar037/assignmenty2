package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponseDTO {

    private Integer seat_id;

    private String seat_no;

    private SeatType seat_type;

    private Integer bus_id;
}