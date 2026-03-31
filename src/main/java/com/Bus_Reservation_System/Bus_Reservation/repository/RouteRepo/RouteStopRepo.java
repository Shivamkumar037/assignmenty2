package com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.*;

import java.util.List;

@Repository
public interface RouteStopRepo extends JpaRepository<RouteStop,Integer> {

    List<RouteStop> findAllByRoute(Route route);

    List<RouteStop> findByRoute_RouteIdOrderBySequenceAsc(Integer routeId);

}
