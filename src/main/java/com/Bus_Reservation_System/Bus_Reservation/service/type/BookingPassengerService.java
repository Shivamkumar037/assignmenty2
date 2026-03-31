package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO.BookingPassengerRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.bookingResponceDTO.BookingPassengerResponseDTO;

import java.util.List;

public interface BookingPassengerService {

    BookingPassengerResponseDTO addPassenger(BookingPassengerRequestDTO request);

    BookingPassengerResponseDTO updatePassenger(Integer passengerId, BookingPassengerRequestDTO request);

    List<BookingPassengerResponseDTO> getPassengersByBookingId(Integer bookingId);

    BookingPassengerResponseDTO getPassengerById(Integer passengerId);

    void deletePassenger(Integer passengerId);
    
    List<BookingPassengerResponseDTO> addMultiplePassengers(List<BookingPassengerRequestDTO> requests);
}