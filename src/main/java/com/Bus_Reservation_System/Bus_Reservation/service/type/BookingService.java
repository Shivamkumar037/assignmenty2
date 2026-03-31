package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO.BookingRequestDTO;
import java.util.List;
import   com.Bus_Reservation_System.Bus_Reservation.dto.Booking.BookingResponseDTO;
public interface BookingService {

   BookingResponseDTO createBooking(BookingRequestDTO bookingRequest);

  BookingResponseDTO updateBookingStatus(Integer bookingId, boolean status);

    BookingResponseDTO getBookingById(Integer bookingId);

    List<BookingResponseDTO> getBookingsByUsername(String username);

    List<BookingResponseDTO> getAllBookings(int pageNumber, int pageSize);

    void cancelBooking(Integer bookingId);
}