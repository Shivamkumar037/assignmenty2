package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.UserRequest;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.UserResponse;

import java.util.List;

public interface UserService {
UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest);
    UserResponse deleteUser(String username);
    UserResponse findUser(String username);
   List<UserResponse> findAllUsers(int pageNumber, int pageSize);

}
