package com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {

    @Query("SELECT COUNT(c) > 0 FROM City c WHERE c.name = :name AND c.state = :state")
    boolean existsNameAndState(@Param("name") String name, @Param("state") String state);
}
