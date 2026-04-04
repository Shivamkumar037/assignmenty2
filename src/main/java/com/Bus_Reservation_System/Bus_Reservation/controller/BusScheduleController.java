package com.Bus_Reservation_System.Bus_Reservation.controller;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.BusScheduleRequest;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.BusScheduleResponce;
import com.Bus_Reservation_System.Bus_Reservation.service.busservice.BusScheduleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class BusScheduleController {
    private final BusScheduleServiceImpl scheduleService;

    @PostMapping
    public BusScheduleResponce create(@RequestBody BusScheduleRequest request) {
        return scheduleService.createSchedule(request);
    }

    @PutMapping("/{id}")
    public BusScheduleResponce update(@PathVariable Integer id, @RequestBody BusScheduleRequest request) {
        return scheduleService.updateSchedule(id, request);
    }

    @GetMapping("/{id}")
    public BusScheduleResponce get(@PathVariable Integer id) {
        return scheduleService.getSchedule(id);
    }

    @GetMapping
    public List<BusScheduleResponce> getAll(@RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam(defaultValue = "10") Integer size) {
        return scheduleService.getAllSchedules(page, size);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
        return "Schedule Deleted Successfully";
    }
}