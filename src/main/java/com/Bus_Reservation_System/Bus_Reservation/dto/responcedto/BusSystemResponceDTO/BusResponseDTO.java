package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.BusSystemResponceDTO;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.Bustype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusResponseDTO {

    private Integer bus_id;

    private String bus_number;

    private Bustype bus_type;

    private Integer total_seat;

    private boolean status;

    private Integer bus_operater_id;
}