package com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {
    @Query("SELECT DISTINCT s1.route.id FROM Stop s1, Stop s2 " +
            "WHERE s1.route.id = s2.route.id " + // Dono stops ek hi route ke hone chahiye
            "AND LOWER(s1.stopName) = LOWER(:source) " + // Source match kare
            "AND LOWER(s2.stopName) = LOWER(:destination) " + // Destination match kare
            "AND s1.distanceFromSource < s2.distanceFromSource") // Sequence check (Source pehle ho)
    List<Integer> findRouteIdsByStops(@Param("source") String source,
                                      @Param("destination") String destination);;




}
