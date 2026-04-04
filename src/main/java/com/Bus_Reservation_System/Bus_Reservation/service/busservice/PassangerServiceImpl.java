package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.PassangerRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.PassangerResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Passanger;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Seat;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.PassangerRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.SeatRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.PassangerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PassangerServiceImpl implements PassangerService {

    private final PassangerRepo passangerRepo;
    private final SeatRepo seatRepo;

    @Override
    public PassangerResponceDTO createPassanger(PassangerRequestDTO dto) {
        Passanger passanger = new Passanger();
        passanger = passangerMapper(dto, passanger);
        passanger = passangerRepo.save(passanger);
        return responseMapper(passanger);
    }

    @Override
    public PassangerResponceDTO updatePassanger(Integer id, PassangerRequestDTO dto) {
        Passanger passanger = passangerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Passanger not found"));
        passanger = passangerMapper(dto, passanger);
        passanger = passangerRepo.save(passanger);
        return responseMapper(passanger);
    }

    @Override
    public void deletePassanger(Integer id) {
        Passanger passanger = passangerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Passanger not found"));
        passangerRepo.delete(passanger);
    }

    @Override
    public PassangerResponceDTO getPassanger(Integer id) {
        Passanger passanger = passangerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Passanger not found"));
        return responseMapper(passanger);
    }

    @Override
    public List<PassangerResponceDTO> getPassangers(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        Page<Passanger> page = passangerRepo.findAll(pageable);
        return page.getContent().stream().map(this::responseMapper).toList();
    }

    private Passanger passangerMapper(PassangerRequestDTO dto, Passanger passanger) {
        passanger.setName(dto.getName());
        passanger.setAadhar(dto.getAadhar());
        passanger.setAddress(dto.getAddress());
        passanger.setPhone(dto.getPhone());


        return passanger;
    }

    private PassangerResponceDTO responseMapper(Passanger passanger) {
        PassangerResponceDTO dto = new PassangerResponceDTO();
        dto.setId(passanger.getId());
        dto.setName(passanger.getName());
        dto.setAadhar(passanger.getAadhar());
        dto.setPhone(passanger.getPhone());
        dto.setAddress(passanger.getAddress());

        return dto;
    }
}