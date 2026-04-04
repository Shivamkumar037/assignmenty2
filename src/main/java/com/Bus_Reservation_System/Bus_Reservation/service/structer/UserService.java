package com.Bus_Reservation_System.Bus_Reservation.service.structer;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.UserRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.UserResponceDTO;
import jakarta.validation.constraints.Email;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {

    UserResponceDTO createUser(UserRequestDTO userRequestDTO);
    UserResponceDTO updateUser(Integer id,UserRequestDTO userRequestDTO);
    UserResponceDTO deleteUser(Integer id);
    UserResponceDTO findUser(Integer id);
    List<UserResponceDTO> findAllUsers(Integer pageno, Integer pagesize);
}
