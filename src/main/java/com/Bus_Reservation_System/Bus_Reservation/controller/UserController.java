package com.Bus_Reservation_System.Bus_Reservation.controller;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.UserRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.UserResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users") // Base path change kiya taaki clean rahe
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. Create User (POST)
    @PostMapping("/create")
    public UserResponceDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    // 2. Get All Users with Pagination (GET)
    // Postman: /api/users?page=0&size=10
    @GetMapping
    public List<UserResponceDTO> getAllUsers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return userService.findAllUsers(page, size);
    }

    // 3. Get Single User by ID (GET)
    @GetMapping("/{id}")
    public UserResponceDTO getUserById(@PathVariable Integer id) {
        return userService.findUser(id);
    }

    // 4. Update User (PUT)
    @PutMapping("/update/{id}")
    public UserResponceDTO updateUser(@PathVariable Integer id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }

    // 5. Delete User (DELETE)
    @DeleteMapping("/delete/{id}")
    public UserResponceDTO deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    // 6. Find User by Email (GET)
    // Postman: /api/users/email?value=arjun@example.com

}