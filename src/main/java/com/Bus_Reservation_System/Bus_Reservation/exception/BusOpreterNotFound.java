package com.Bus_Reservation_System.Bus_Reservation.exception;

public class BusOpreterNotFound extends RuntimeException{

    public BusOpreterNotFound(String opreterNotFound) {
        super(opreterNotFound);
    }

}
