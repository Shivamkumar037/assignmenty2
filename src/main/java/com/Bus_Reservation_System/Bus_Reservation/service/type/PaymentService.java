package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO.PaymentRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.bookingResponceDTO.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    PaymentResponseDTO processPayment(PaymentRequestDTO request);

    PaymentResponseDTO getPaymentById(Integer paymentId);

    PaymentResponseDTO getPaymentByTransactionId(String transactionId);

    PaymentResponseDTO getPaymentByBookingId(Integer bookingId);

    List<PaymentResponseDTO> getAllPayments(int pageNumber, int pageSize);

    PaymentResponseDTO updatePaymentStatus(Integer paymentId, boolean status);
}