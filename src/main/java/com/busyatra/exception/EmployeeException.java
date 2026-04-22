package com.busyatra.exception;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String somethingWrong) {
        super(somethingWrong);
    }
}
