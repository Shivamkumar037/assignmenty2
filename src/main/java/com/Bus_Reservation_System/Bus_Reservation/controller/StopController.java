package com.Bus_Reservation_System.Bus_Reservation.controller;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.StopRequest;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.StopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stops")
@RequiredArgsConstructor
public class StopController {
    private final StopService stopService;

    @PostMapping
    public Stop create(@RequestBody StopRequest request) {
        return stopService.createStop(request);
    }

    @GetMapping("/route/{routeId}")
    public List<Stop> getStopsByRoute(@PathVariable Integer routeId) {
        return stopService.getAllStops(routeId);
    }
}