package com.Bus_Reservation_System.Bus_Reservation.exception;

public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException(String routeNotFound) {

        super(routeNotFound);
    }

}
