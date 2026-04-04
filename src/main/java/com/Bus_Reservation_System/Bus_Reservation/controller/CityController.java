package com.Bus_Reservation_System.Bus_Reservation.controller;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.CityRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.StopRequest;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.CityResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.CityService;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.StopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public CityResponceDTO create(@RequestBody CityRequestDTO request) {
        return cityService.createCity(request);
    }

    @GetMapping
    public List<CityResponceDTO> getAll(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size) {
        return cityService.getAllCity(page, size);
    }
}
