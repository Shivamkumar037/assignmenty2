package com.busyatra.controller;

import com.busyatra.dto.ApiResponse;
import com.busyatra.dto.CancelTicketRequest;
import com.busyatra.entity.Cancellation;
import com.busyatra.entity.Refund;
import com.busyatra.service.CancellationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ticket")
public class CancellationController {

    @Autowired
    private CancellationService cancellationService;

    @PostMapping("/cancel")
    public ResponseEntity<ApiResponse> cancelTicket(@Valid @RequestBody CancelTicketRequest request) {
        Cancellation cancellation = cancellationService.cancelTicket(request);
        return ResponseEntity.ok(
                new ApiResponse(true, "Ticket cancelled successfully", cancellation)
        );
    }


    @GetMapping("/refund/status/{bookingId}")
    public ResponseEntity<ApiResponse> getRefundStatus(@PathVariable String bookingId) {
        Refund refund = cancellationService.getRefundStatus(bookingId);
        return ResponseEntity.ok(
                new ApiResponse(true, "Refund status retrieved", refund)
        );
    }
}