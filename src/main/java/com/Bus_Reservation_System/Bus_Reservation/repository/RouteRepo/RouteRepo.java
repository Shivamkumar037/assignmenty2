package com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {

    List<Route> getRoutesBySourceAndDestination(Integer sourceCityId, Integer destinationCityId);



}
