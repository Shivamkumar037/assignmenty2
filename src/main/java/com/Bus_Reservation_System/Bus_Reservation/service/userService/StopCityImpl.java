package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.Stop_CtiyRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.Stop_CtiyResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Stop_Ctiy;
import com.Bus_Reservation_System.Bus_Reservation.exception.CityNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.Stop_CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.StopCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StopCityImpl implements StopCityService {
private final Stop_CityRepo stopCityRepo;
private final CityRepo cityRepo;
    @Override
    public Stop_CtiyResponseDTO addStopToCity(Stop_CtiyRequestDTO request) {
Stop_Ctiy stopCtiy=requestMapping(request,new Stop_Ctiy());
stopCtiy=stopCityRepo.save(stopCtiy);
return responceMapping(stopCtiy);
    }

    @Override
    public Stop_CtiyResponseDTO updateStopDetails(Integer stopId, Stop_CtiyRequestDTO request) {
Stop_Ctiy stopCtiy=stopCityRepo.findById(stopId).orElseThrow(()->new CityNotFoundException("City Not Found"));
        return responceMapping(stopCityRepo.save(requestMapping(request,stopCtiy)));
    }

    @Override
    public Stop_CtiyResponseDTO getStopById(Integer stopId) {
        Stop_Ctiy stopCtiy=stopCityRepo.findById(stopId).orElseThrow(()->new CityNotFoundException("City Not Found"));

        return responceMapping(stopCtiy);
    }

    @Override
    public List<Stop_CtiyResponseDTO> getStopsByCityId(Integer cityId) {
City city= cityRepo.findById(cityId).orElseThrow(()-> new CityNotFoundException("City Not Found Exception"));
      List<Stop_Ctiy> stopCtiyList=stopCityRepo.findAllByStop(city);

        return stopCtiyList.stream().map(stop->responceMapping(stop)).toList();
    }

    @Override
    public List<Stop_CtiyResponseDTO> getAllStops(int pageNumber, int pageSize) {

        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        Page<Stop_Ctiy> stopCtiyPage=stopCityRepo.findAll(pageable);
        return stopCtiyPage.getContent().stream().map(stopCtiy -> responceMapping(stopCtiy)).toList();
    }

    @Override
    public void deleteStop(Integer stopId) {
        Stop_Ctiy stopCtiy=stopCityRepo.findById(stopId).orElseThrow(()->new CityNotFoundException("City Not Found"));
stopCityRepo.delete(stopCtiy);
    }

    @Override
    public List<Stop_CtiyResponseDTO> getStopsByName(String stopName) {
        List<Stop_Ctiy> stopCtiyList=stopCityRepo.findAllByStopName(stopName);
        return stopCtiyList.stream().map(stopCtiy -> responceMapping(stopCtiy)).toList();
    }
    Stop_Ctiy requestMapping(Stop_CtiyRequestDTO requestDTO,Stop_Ctiy stopCtiy){
        if(requestDTO.getStop_name()!=null){
            stopCtiy.setStop_name(requestDTO.getStop_name());
        }
        if(requestDTO.getTime()!=null){
            stopCtiy.setTime(requestDTO.getTime());
        }
        if(requestDTO.getCity_id()!=null){
            City city=cityRepo.findById(requestDTO.getCity_id()).orElseThrow(()->new CityNotFoundException(" City Not found Exception"));
            stopCtiy.setCity(city);
        }
        return stopCtiy;
    }

    Stop_CtiyResponseDTO responceMapping(Stop_Ctiy stopCtiy){
        Stop_CtiyResponseDTO stop_CtiyResponseDTO= new Stop_CtiyResponseDTO();
        stop_CtiyResponseDTO.setStop_name(stopCtiy.getStop_name());
        stop_CtiyResponseDTO.setStop_id(stopCtiy.getStop_id());
        stop_CtiyResponseDTO.setTime(stopCtiy.getTime());
        stop_CtiyResponseDTO.setCity_id(stopCtiy.getCity().getCity_id());
        return stop_CtiyResponseDTO;
    }
}
