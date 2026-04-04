package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassangerRequestDTO {
    private String name;
    private String aadhar;
    private String phone;
    private String email;
    private String address;
    private String source ;
    private String destination;
    private Integer scheduleid;

}
