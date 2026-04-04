package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user;
import com.Bus_Reservation_System.Bus_Reservation.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponceDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private LocalDate dob;
    private boolean isActive=true;
    private boolean isVerified=false;
    private String aadhar;
    private Role role;
}
