package com.Bus_Reservation_System.Bus_Reservation.exception;

public class StopNotFoundException extends RuntimeException {
    public StopNotFoundException(String stopNoytFound) {
        super(stopNoytFound);
    }
}
