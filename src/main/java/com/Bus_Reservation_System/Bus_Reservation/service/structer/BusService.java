package com.Bus_Reservation_System.Bus_Reservation.service.structer;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.BusRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.BusResponceDTO;

import java.util.List;

public interface BusService {
    BusResponceDTO createBus(BusRequestDTO busRequestDTO);
    BusResponceDTO updateBus(Integer id,BusRequestDTO busRequestDTO);
    void deleteBus(Integer id);
    BusResponceDTO getBus(Integer id);
    List<BusResponceDTO> getBuses(Integer pageno, Integer pagesize);

    BusResponceDTO getBusByBusNo(String busNo);

}
