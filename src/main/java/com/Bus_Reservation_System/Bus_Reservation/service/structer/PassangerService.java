package com.Bus_Reservation_System.Bus_Reservation.service.structer;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.PassangerRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.PassangerResponceDTO;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface PassangerService {
    PassangerResponceDTO createPassanger(PassangerRequestDTO passangerRequestDTO);
    void deletePassanger(Integer passangerId);
    PassangerResponceDTO getPassanger(Integer passangerId);
    PassangerResponceDTO updatePassanger(Integer id ,PassangerRequestDTO passangerRequestDTO);
    List<PassangerResponceDTO> getPassangers(Integer pageno, Integer pagesize);

}
