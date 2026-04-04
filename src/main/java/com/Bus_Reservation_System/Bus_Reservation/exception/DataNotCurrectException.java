package com.Bus_Reservation_System.Bus_Reservation.exception;

public class DataNotCurrectException extends RuntimeException {
    public DataNotCurrectException(String dataNotCurrect) {
        super(dataNotCurrect);
    }
}
