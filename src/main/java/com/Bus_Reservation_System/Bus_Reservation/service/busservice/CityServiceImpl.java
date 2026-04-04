package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.CityRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.CityResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.CityService;
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
@Transactional
public class CityServiceImpl implements CityService {
    private  final CityRepo cityRepo;
    private ModelMapper  modelMapper;

    @Override
    public List<CityResponceDTO> createCity(List<CityRequestDTO> cityRequestDTO) {

      return cityRequestDTO.stream().map(city->createCity(city)).toList();
    }

    @Override
    public CityResponceDTO createCity(CityRequestDTO cityRequestDTO) {
if(        cityRepo.existsNameAndState(cityRequestDTO.getName(),cityRequestDTO.getState())
)    {
    throw new RuntimeException("City already exists");
}else {
    City city = modelMapper.map(cityRequestDTO,City.class);
    city = cityRepo.save(city);
    return modelMapper.map(city,CityResponceDTO.class);
}

    }

    @Override
    public CityResponceDTO updateCity(Integer id ,CityRequestDTO cityRequestDTO) {
       City city = cityRepo.findById(id).orElseThrow(()->new RuntimeException("City not found"));
       modelMapper.map(cityRequestDTO,city);
       city = cityRepo.save(city);
        return modelMapper.map(city,CityResponceDTO.class);
    }

    @Override
    public void deleteCity(Integer id) {
        City city = cityRepo.findById(id).orElseThrow(()->new RuntimeException("City not found"));
cityRepo.delete(city);

    }

    @Override
    public CityResponceDTO getCity(Integer id) {
        City city = cityRepo.findById(id).orElseThrow(()->new RuntimeException("City not found"));
return modelMapper.map(city,CityResponceDTO.class);
    }

    @Override
    public List<CityResponceDTO> getAllCity(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno,pagesize);
        Page<City> page = cityRepo.findAll(pageable);
        return  page.getContent().stream().map(city->modelMapper.map(city, CityResponceDTO.class)).toList();

    }
}
