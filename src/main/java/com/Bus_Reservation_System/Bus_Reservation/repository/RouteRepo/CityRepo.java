package com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {

    List<City> findAllByState(String state);

    boolean existsByCityAndState(String cityName, String state);

}
