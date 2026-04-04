package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.UserRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.UserResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Role;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.RoleType;
import com.Bus_Reservation_System.Bus_Reservation.repository.RoleRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.UserReop;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
@Transactional
public class UserServiceImpl implements UserService {

    private final UserReop userReop;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponceDTO createUser(UserRequestDTO dto) {

        if (userReop.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists!");
        }

        User user = userMapper(dto, new User());

        assignDefaultRole(user);

        User savedUser = userReop.save(user);
        return userResponceMapper(savedUser);
    }

    @Override
    public UserResponceDTO updateUser(Integer id, UserRequestDTO dto) {
        return userReop.findById(id)
                .map(existingUser -> {
                    User updated = userMapper(dto, existingUser);
                    return userResponceMapper(userReop.save(updated));
                })
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with ID: " + id));
    }

    @Override
    public UserResponceDTO deleteUser(Integer id) {
        User user = userReop.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

         userReop.delete(user);
        return userResponceMapper(user);
    }

    @Override
    @Transactional
    public UserResponceDTO findUser(Integer id) {
        return userReop.findById(id)
                .map(this::userResponceMapper)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    @Transactional
    public List<UserResponceDTO> findAllUsers(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize, Sort.by("name").ascending());
        Page<User> usersPage = userReop.findAll(pageable);

        if (usersPage.isEmpty()) {
            throw new UsernameNotFoundException("User not Found");
        }

        return usersPage.getContent().stream()
                .map(this::userResponceMapper)
                .toList();
    }


    private void assignDefaultRole(User user) {
        if (user.getRole() == null) {
            Role role = roleRepo.findByRole(RoleType.PASSENGER);
            if (role == null) {
                role = new Role();
                role.setRole(RoleType.PASSENGER);
                role = roleRepo.save(role);
            }
            user.setRole(role);
        }
    }

    private User userMapper(UserRequestDTO dto, User user) {
        if (dto.getEmail() != null) user.setEmail(dto.getEmail().trim().toLowerCase());
        if (dto.getPassword() != null) user.setPassword(passwordEncoder.encode(dto.getPassword()));
        if (dto.getAadhar() != null) user.setAadhar(dto.getAadhar());
        if (dto.getPhone() != null) user.setPhone(dto.getPhone());
        if (dto.getName() != null) user.setName(dto.getName().trim());
        if (dto.getDob() != null) user.setDob(dto.getDob());

        return user;
    }

    private UserResponceDTO userResponceMapper(User user) {
        UserResponceDTO dto = new UserResponceDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setDob(user.getDob());
        dto.setVerified(user.isVerified());
        dto.setActive(user.isActive());
        dto.setPhone(user.getPhone());
        dto.setAadhar(user.getAadhar());
        return dto;
    }
}