package com.Bus_Reservation_System.Bus_Reservation.exception;

public class SeatNotFoundException extends RuntimeException {

    public SeatNotFoundException(String seatNotFound) {
        super(seatNotFound);
    }

}
