package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Integer user_id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private boolean status;
    private LocalDateTime created_time;
    private String roleName;}