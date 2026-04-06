package com.busyatra.controller;

import com.busyatra.dto.ApiResponse;
import com.busyatra.entity.Route;
import com.busyatra.entity.Stop;
import com.busyatra.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @GetMapping
    public ResponseEntity<ApiResponse> getAllRoutes() {
        List<Route> routes = routeService.getActiveRoutes();
        return ResponseEntity.ok(new ApiResponse(true, "Routes retrieved successfully", routes));
    }


    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchRoutes(
            @RequestParam Long sourceCityId,
            @RequestParam Long destinationCityId) {
        List<Route> routes = routeService.searchRoutes(sourceCityId, destinationCityId);
        return ResponseEntity.ok(new ApiResponse(true, "Routes found", routes));
    }


    @GetMapping("/{routeId}/stops")
    public ResponseEntity<ApiResponse> getStops(@PathVariable Long routeId) {
        List<Stop> stops = routeService.getStopsForRoute(routeId);
        return ResponseEntity.ok(new ApiResponse(true, "Stops retrieved", stops));
    }
}