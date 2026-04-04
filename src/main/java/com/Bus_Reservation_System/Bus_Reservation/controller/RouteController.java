package com.Bus_Reservation_System.Bus_Reservation.controller;
import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.RouteRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.RouteResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.SouceDestinationRequestDto;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @PostMapping
    public RouteResponseDTO create(@RequestBody RouteRequestDTO request) {
        return routeService.createRoute(request);
    }

    @GetMapping("/search")
    public List<RouteResponseDTO> search(@RequestParam String source, @RequestParam String destination) {
        SouceDestinationRequestDto dto = new SouceDestinationRequestDto(source, destination);
        return routeService.getRoutesBySourceAndDestination(dto);
    }

    @GetMapping("/{id}")
    public RouteResponseDTO getById(@PathVariable Integer id) {
        return routeService.getRoute(id);
    }

    @GetMapping
    public List<RouteResponseDTO> getAll(@RequestParam(defaultValue = "0") Integer page, 
                                         @RequestParam(defaultValue = "10") Integer size) {
        return routeService.getRoutes(page, size);
    }
}