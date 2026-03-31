package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.UserRequest;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.UserResponse;
import com.Bus_Reservation_System.Bus_Reservation.entity.Role;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.RoleType;
import com.Bus_Reservation_System.Bus_Reservation.exception.RoleNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.exception.UserAlredyExist;
import com.Bus_Reservation_System.Bus_Reservation.repository.RoleRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.UserReop;
import com.Bus_Reservation_System.Bus_Reservation.service.type.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserReop userReop;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepo roleRepo;

    @Transactional
    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if (userReop.existsByUsername(userRequest.getUsername())) {
            throw new UserAlredyExist("User With Username :- " + userRequest.getUsername() + " Already Exists");
        }
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        Role role;
        if(userRequest.getRoleId()!=null){
           role  = roleRepo.findById(userRequest.getRoleId()).orElseThrow(() -> new RoleNotFoundException("Role Not " +
                    "Found"));
        }else {
            role = roleRepo.findByRole(RoleType.PASSENGER).orElseThrow(() -> new RoleNotFoundException("Role Not " +
                    "Found"));
        } user.setRole(role);
        User saveduser = userReop.save(user);
        return modelMapper.map(saveduser, UserResponse.class);

    }

    @Transactional
    @Override
    public UserResponse updateUser(UserRequest userRequest) {

        User user =
                userReop.findByUsername(userRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException(
                        "User Not Exist"));

        String oldpassword= user.getPassword();
        modelMapper.map(userRequest, user);
        if (userRequest.getPassword() != null && !userRequest.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        }else {
            user.setPassword(oldpassword);
        }
        User updateuser = userReop.save(user);
        return modelMapper.map(updateuser, UserResponse.class);
    }

    @Transactional
    @Override
    public UserResponse deleteUser(String username) {

        User user = userReop.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                        "User Not Exist"));
        UserResponse responce = modelMapper.map(user, UserResponse.class);
        userReop.delete(user);
        return responce;
    }

    @Override
    public UserResponse findUser(String username) {

        User user =
                userReop.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                        "User Not Exist"));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> findAllUsers(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("username").ascending());
        Page<User> page = userReop.findAll(pageable);
        return page.getContent().stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();

    }

}
