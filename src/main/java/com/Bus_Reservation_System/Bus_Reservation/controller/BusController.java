package com.Bus_Reservation_System.Bus_Reservation.controller;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.BusRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.BusResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buses")
@RequiredArgsConstructor
public class BusController {
    private final BusService busService;

    @PostMapping
    public BusResponceDTO create(@RequestBody BusRequestDTO request) {
        return busService.createBus(request);
    }

    @GetMapping("/{id}")
    public BusResponceDTO getById(@PathVariable Integer id) {
        return busService.getBus(id);
    }

    @GetMapping("/number/{busNo}")
    public BusResponceDTO getByBusNo(@PathVariable String busNo) {
        return busService.getBusByBusNo(busNo);
    }

    @PutMapping("/{id}")
    public BusResponceDTO update(@PathVariable Integer id, @RequestBody BusRequestDTO request) {
        return busService.updateBus(id, request);
    }
}