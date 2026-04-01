package com.Bus_Reservation_System.Bus_Reservation.exception;

import jakarta.validation.constraints.NotBlank;

public class UserAlredyExistException extends RuntimeException {

    public UserAlredyExistException(@NotBlank(message = "Username is required") String s) {}

}
