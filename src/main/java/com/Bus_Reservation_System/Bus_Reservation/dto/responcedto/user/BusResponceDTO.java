package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user;

import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.Bustype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusResponceDTO {

    private Integer id;
    private String busNo;
    private Bustype bustype;
    private Integer totalSeats;
    private boolean status=true;
    private User drivar;
    private User conductor;

}
