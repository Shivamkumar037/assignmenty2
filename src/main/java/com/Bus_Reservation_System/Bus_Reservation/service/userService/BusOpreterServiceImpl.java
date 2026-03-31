package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.BusSystemRequestDTO.BusOperaterRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.BusSystemResponceDTO.BusOperaterResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.BusOperater;
import com.Bus_Reservation_System.Bus_Reservation.exception.BusOpreterNotFound;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.BusOperaterRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.BusOperatorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusOpreterServiceImpl implements BusOperatorService {
    private  final BusOperaterRepo busOperaterRepo;
    private  final ModelMapper modelMapper;

    @Override
    public BusOperaterResponseDTO createOperator(BusOperaterRequestDTO request) {

        BusOperater busOperater=modelMapper.map(request,BusOperater.class);

        return modelMapper.map( busOperaterRepo.save(busOperater), BusOperaterResponseDTO.class);

    }

    @Override
    public BusOperaterResponseDTO updateOperator(Integer id, BusOperaterRequestDTO request) {
        BusOperater busOperater= busOperaterRepo.findById(id).orElseThrow(()->new BusOpreterNotFound("Opreter Not Found"));
       modelMapper.map(request,busOperater);
        return modelMapper.map(busOperaterRepo.save( busOperater), BusOperaterResponseDTO.class);
    }

    @Override
    public void deleteOperator(Integer id) {
        BusOperater busOperater= busOperaterRepo.findById(id).orElseThrow(()->new BusOpreterNotFound("Opreter Not Found"));

       busOperaterRepo.delete(busOperater);
    }

    @Override
    public BusOperaterResponseDTO findOperatorById(Integer id) {
        BusOperater busOperater= busOperaterRepo.findById(id).orElseThrow(()->new BusOpreterNotFound("Opreter Not Found"));

        return modelMapper.map(busOperater, BusOperaterResponseDTO.class);
    }

    @Override
    public List<BusOperaterResponseDTO> findAllOperators(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<BusOperater> page=busOperaterRepo.findAll(pageable);
        return page.getContent().stream().map(busOperater -> modelMapper.map(busOperater, BusOperaterResponseDTO.class)).toList();
    }

}
