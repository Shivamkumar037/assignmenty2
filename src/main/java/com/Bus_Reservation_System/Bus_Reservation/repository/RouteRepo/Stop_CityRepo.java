package com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Stop_Ctiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Stop_CityRepo extends JpaRepository<Stop_Ctiy,Integer> {

    List<Stop_Ctiy> findAllByStop(City city);

    List<Stop_Ctiy> findAllByStopName(String stopName);

}
