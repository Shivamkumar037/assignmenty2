package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.BusSystemRequestDTO.BusRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.BusSystemResponceDTO.BusResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.BusOperater;
import com.Bus_Reservation_System.Bus_Reservation.exception.BusNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.exception.OpreterNotFound;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.BusOperaterRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.BusRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.BusService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {

    private final BusRepo busRepo;

    private final BusOperaterRepo busOperaterRepo;

    @Transactional
    @Override
    public BusResponseDTO createBus(BusRequestDTO busRequest) {
        if (busRepo.existsByBusNumber(busRequest.getBus_number())) {
            throw new RuntimeException("Bus with this number already exists!");
        }
        Bus bus=requestMapper(busRequest,new Bus());
        Bus savedbus = busRepo.save(bus);
        return responceMapper(savedbus);
    }



    @Transactional
    @Override
    public BusResponseDTO updateBus(Integer busId, BusRequestDTO busRequest) {

        Bus bus = busRepo.findById(busId).orElseThrow(() -> new BusNotFoundException("Bus Not Found"));
       bus= requestMapper(busRequest,bus);

        return responceMapper(busRepo.save(bus));
    }

    @Transactional
    @Override
    public BusResponseDTO deleteBus(Integer busId) {

        Bus bus = busRepo.findById(busId).orElseThrow(() -> new BusNotFoundException("Bus Not Found"));
        busRepo.delete(bus);
        return responceMapper(bus);
    }

    @Transactional
    @Override
    public BusResponseDTO findBusById(Integer busId) {

        Bus bus = busRepo.findById(busId).orElseThrow(() -> new BusNotFoundException("Bus Not Found"));
        return responceMapper(bus);
    }

    @Transactional
    @Override
    public List<BusResponseDTO> findAllBuses(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Bus> pages = busRepo.findAll(pageable);
        return pages.stream().map(bus -> responceMapper(
                bus
        )).toList();
    }

    BusResponseDTO responceMapper(Bus bus){
        BusResponseDTO busResponseDTO= new BusResponseDTO();
        busResponseDTO.setBus_type(bus.getBus_type());
        busResponseDTO.setBus_number(bus.getBus_number());
        busResponseDTO.setBus_id(bus.getBus_id());
        busResponseDTO.setTotal_seat(bus.getTotal_seat());
        busResponseDTO.setStatus(bus.getStatus());

if(bus.getBusOperater()!=null){
    busResponseDTO.setBus_operater_id(bus.getBusOperater().getBusoperater_id());

}
        return busResponseDTO;
    }
// It is For Menual Mapping For Safty of obj
    Bus requestMapper(BusRequestDTO busRequest,Bus bus){

        if(busRequest.getBus_operater_id()!=null){
            BusOperater busOperater =
                    busOperaterRepo.findById(busRequest.getBus_operater_id()).orElseThrow(() -> new OpreterNotFound(
                            "Opreter Not Found"));
            bus.setBusOperater(busOperater);
        }
        if(busRequest.getBus_number()!=null) {
            bus.setBus_number(busRequest.getBus_number());
        }
        if(busRequest.getBus_type()!=null){
            bus.setBus_type(busRequest.getBus_type());
        }
        if(busRequest.getTotal_seat()!=null){
            bus.setTotal_seat(busRequest.getTotal_seat());
        }
        return bus;
    }

}
