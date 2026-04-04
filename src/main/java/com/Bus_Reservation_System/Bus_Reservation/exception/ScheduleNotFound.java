package com.Bus_Reservation_System.Bus_Reservation.exception;

public class ScheduleNotFound extends RuntimeException{
    public ScheduleNotFound(String scheduleNotFound) {
        super(scheduleNotFound);
    }
}
