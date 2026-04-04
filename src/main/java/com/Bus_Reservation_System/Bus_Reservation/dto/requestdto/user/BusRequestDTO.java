package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.Bustype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusRequestDTO {
    private String busNo;
    private Bustype bustype;
    private Integer totalSeats;
    private boolean status=true;
    private Integer drivar;
    private Integer conductor;
}
