package com.busyatra.service;

import com.busyatra.dto.CancelTicketRequest;
import com.busyatra.entity.*;
import com.busyatra.exception.BadRequestException;
import com.busyatra.exception.ResourceNotFoundException;
import com.busyatra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class CancellationService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CancellationRepository cancellationRepository;

    @Autowired
    private RefundRepository refundRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private SeatAvailabilityRepository seatAvailabilityRepository;

    @Autowired
    private EmailService emailService;


    @Transactional
    public Cancellation cancelTicket(CancelTicketRequest request) {
        Booking booking = bookingRepository.findByBookingId(request.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "bookingId", request.getBookingId()));

        if ("CANCELLED".equals(booking.getBookingStatus())) {
            throw new BadRequestException("Booking is already cancelled");
        }

        if (!"CONFIRMED".equals(booking.getBookingStatus())) {
            throw new BadRequestException("Only confirmed bookings can be cancelled");
        }

        BigDecimal refundAmount = calculateRefund(booking);

        Cancellation cancellation = new Cancellation();
        cancellation.setBooking(booking);
        cancellation.setRefundAmount(refundAmount);
        cancellation.setReason(request.getReason());
        cancellation = cancellationRepository.save(cancellation);

        Refund refund = new Refund();
        refund.setCancellation(cancellation);
        refund.setRefundStatus("PENDING");
        refundRepository.save(refund);

        booking.setBookingStatus("CANCELLED");
        bookingRepository.save(booking);

        releaseSeats(booking);

        emailService.sendCancellationEmail(
                booking.getUser().getEmail(),
                booking.getBookingId(),
                refundAmount.toString()
        );

        return cancellation;
    }


    private BigDecimal calculateRefund(Booking booking) {
        LocalDate travelDate = booking.getSchedule().getTravelDay();
        LocalDate today = LocalDate.now();
        long daysUntilTravel = ChronoUnit.DAYS.between(today, travelDate);

        BigDecimal totalAmount = booking.getTotalAmount();
        BigDecimal refundPercentage;

        // Cancellation policy:
        // More than 7 days: 90% refund
        // 3-7 days: 75% refund
        // 1-2 days: 50% refund
        // Same day: 25% refund
        // After travel date: No refund

        if (daysUntilTravel < 0) {
            refundPercentage = BigDecimal.ZERO;
        } else if (daysUntilTravel == 0) {
            refundPercentage = BigDecimal.valueOf(0.25);
        } else if (daysUntilTravel <= 2) {
            refundPercentage = BigDecimal.valueOf(0.50);
        } else if (daysUntilTravel <= 7) {
            refundPercentage = BigDecimal.valueOf(0.75);
        } else {
            refundPercentage = BigDecimal.valueOf(0.90);
        }

        return totalAmount.multiply(refundPercentage);
    }


    private void releaseSeats(Booking booking) {
        List<Passenger> passengers = passengerRepository.findByBooking(booking);
        Schedule schedule = booking.getSchedule();

        for (Passenger passenger : passengers) {
            List<SeatAvailability> availabilities = seatAvailabilityRepository.findBySchedule(schedule);
            
            for (SeatAvailability availability : availabilities) {
                if (availability.getSeat().getId().equals(passenger.getSeat().getId())) {
                    availability.setIsAvailable(true);
                    seatAvailabilityRepository.save(availability);
                    break;
                }
            }
        }
    }


    public Refund getRefundStatus(String bookingId) {
        Booking booking = bookingRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "bookingId", bookingId));

        Cancellation cancellation = cancellationRepository.findByBooking(booking)
                .orElseThrow(() -> new ResourceNotFoundException("Cancellation not found for this booking"));

        return refundRepository.findByCancellation(cancellation)
                .orElseThrow(() -> new ResourceNotFoundException("Refund not found"));
    }


    @Transactional
    public void processRefund(Long refundId, String transactionId) {
        Refund refund = refundRepository.findById(refundId)
                .orElseThrow(() -> new ResourceNotFoundException("Refund", "id", refundId));

        refund.setRefundStatus("COMPLETED");
        refund.setTransactionId(transactionId);
        refund.setRefundDate(java.time.LocalDateTime.now());
        refundRepository.save(refund);
    }
}