package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.CityRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.CityResponseDTO;

import java.util.List;

public interface CityService {

    CityResponseDTO addCity(CityRequestDTO request);

    CityResponseDTO updateCity(Integer cityId, CityRequestDTO request);

    CityResponseDTO getCityById(Integer cityId);

    List<CityResponseDTO> getCitiesByState(String state);

    List<CityResponseDTO> getAllCities(int pageNumber, int pageSize);

    void deleteCity(Integer cityId);
    
    boolean existsByCityNameAndState(String cityName, String state);
}