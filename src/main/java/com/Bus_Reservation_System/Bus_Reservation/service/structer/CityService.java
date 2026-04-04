package com.Bus_Reservation_System.Bus_Reservation.service.structer;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.CityRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.CityResponceDTO;

import java.util.List;

public interface CityService {
    List<CityResponceDTO> createCity(List<CityRequestDTO> cityRequestDTO);
    CityResponceDTO createCity(CityRequestDTO cityRequestDTO);
    CityResponceDTO updateCity(Integer id,CityRequestDTO cityRequestDTO);
    void deleteCity(Integer id);
    CityResponceDTO getCity(Integer id);
    List<CityResponceDTO> getAllCity(Integer pageno, Integer pagesize);
}
