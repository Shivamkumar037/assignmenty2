package com.busyatra.service;

import com.busyatra.dto.AddBusRequest;
import com.busyatra.entity.Bus;
import com.busyatra.entity.Seat;
import com.busyatra.entity.User;
import com.busyatra.exception.BadRequestException;
import com.busyatra.exception.ResourceNotFoundException;
import com.busyatra.repository.BusRepository;
import com.busyatra.repository.SeatRepository;
import com.busyatra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;


    @Transactional
    public Bus addBus(AddBusRequest request) {
        if (busRepository.existsByBusNo(request.getBusNo())) {
            throw new BadRequestException("Bus number already exists");
        }

        Bus bus = new Bus();
        bus.setBusNo(request.getBusNo());
        bus.setBusType(request.getBusType());
        bus.setTotalSeats(request.getTotalSeats());
        bus.setStatus("ACTIVE");

        if (request.getDriverId() != null) {
            User driver = userRepository.findById(request.getDriverId())
                    .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", request.getDriverId()));
            bus.setDriver(driver);
        }

        if (request.getConductorId() != null) {
            User conductor = userRepository.findById(request.getConductorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Conductor", "id", request.getConductorId()));
            bus.setConductor(conductor);
        }

        bus = busRepository.save(bus);

        createSeatsForBus(bus, request.getTotalSeats());

        return bus;
    }


    private void createSeatsForBus(Bus bus, int totalSeats) {
        for (int i = 1; i <= totalSeats; i++) {
            Seat seat = new Seat();
            seat.setBus(bus);
            seat.setSeatNo(String.valueOf(i));
            // Assume seats 1-20 are SEATER, rest are SLEEPER (example logic)
            seat.setSeatType(i <= 20 ? "SEATER" : "SLEEPER");
            seatRepository.save(seat);
        }
    }


    public Bus getBusByNumber(String busNo) {
        return busRepository.findByBusNo(busNo)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "busNo", busNo));
    }


    public List<Bus> getAllActiveBuses() {
        return busRepository.findByStatus("ACTIVE");
    }


    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }


    @Transactional
    public Bus updateBusStatus(Long busId, String status) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "id", busId));
        bus.setStatus(status);
        return busRepository.save(bus);
    }
}