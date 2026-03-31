package com.Bus_Reservation_System.Bus_Reservation.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String cityNotFound) {
        super(cityNotFound);
    }

}
