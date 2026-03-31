package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.CancellationRequest;
import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO.CancellationRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.CancellationResponse;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.bookingResponceDTO.CancellationResponseDTO;

import java.util.List;

public interface CancellationService {

    CancellationResponseDTO processCancellation(CancellationRequestDTO request);

    CancellationResponseDTO getCancellationById(Integer cancellationId);

    CancellationResponseDTO getCancellationByBookingId(Integer bookingId);

    List<CancellationResponseDTO> getAllCancellations(int pageNumber, int pageSize);

    CancellationResponseDTO updateRefundStatus(Integer cancellationId, boolean status);
}