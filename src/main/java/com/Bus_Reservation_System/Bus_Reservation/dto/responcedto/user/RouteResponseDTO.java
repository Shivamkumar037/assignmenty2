package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponseDTO {
    private Integer id;

    private String sourceCityName;
    private String destinationCityName;

    private double distance;
    private double price;

    private List<StopResponceDTO> stops;
}
