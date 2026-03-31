package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.CityRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.CityResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.exception.CityNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.CityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
private final ModelMapper modelMapper;
private  final CityRepo cityRepo;
    @Override
    public CityResponseDTO addCity(CityRequestDTO request) {
        City city = modelMapper.map(request,City.class);
        return modelMapper.map(cityRepo.save(city),CityResponseDTO.class);
    }

    @Override
    public CityResponseDTO updateCity(Integer cityId, CityRequestDTO request) {
City city=cityRepo.findById(cityId).orElseThrow(()-> new CityNotFoundException("City not Found"));
       modelMapper.map(request,city);
        return modelMapper.map(cityRepo.save(city),CityResponseDTO.class);
    }

    @Override
    public CityResponseDTO getCityById(Integer cityId) {
        City city=cityRepo.findById(cityId).orElseThrow(()-> new CityNotFoundException("City not Found"));
        return modelMapper.map(city,CityResponseDTO.class);
    }

    @Override
    public List<CityResponseDTO> getCitiesByState(String state) {
        List<City> citys=cityRepo.findAllByState(state);
        if(citys==null){
            throw  new CityNotFoundException(" City not found");
        }
        return   citys.stream().map(city->modelMapper.map(city,CityResponseDTO.class)).toList();


    }

    @Override
    public List<CityResponseDTO> getAllCities(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by("city").ascending());

       Page<City> citys=cityRepo.findAll(pageable);
        if(citys==null){
            throw  new CityNotFoundException(" City not found");
        }
        return   citys.getContent().stream().map(city->modelMapper.map(city,CityResponseDTO.class)).toList();


    }

    @Override
    public void deleteCity(Integer cityId) {
        City city=cityRepo.findById(cityId).orElseThrow(()-> new CityNotFoundException("City not Found"));
        cityRepo.delete(city);
    }

    @Override
    public boolean existsByCityNameAndState(String cityName, String state) {

        return cityRepo.existsByCityAndState( cityName,  state);
    }

}
