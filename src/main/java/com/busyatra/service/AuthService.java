package com.busyatra.service;

import com.busyatra.dto.*;
import com.busyatra.entity.Role;
import com.busyatra.entity.User;
import com.busyatra.exception.BadRequestException;
import com.busyatra.exception.ResourceNotFoundException;
import com.busyatra.exception.UnauthorizedException;
import com.busyatra.repository.RoleRepository;
import com.busyatra.repository.UserRepository;
import com.busyatra.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private OtpService otpService;


    @Transactional
    public ApiResponse signup(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email is already registered");
        }

        if (userRepository.existsByMobileNo(request.getMobileNo())) {
            throw new BadRequestException("Mobile number is already registered");
        }

        Role role = roleRepository.findByRoleName(request.getRoleName())
                .orElseThrow(() -> new ResourceNotFoundException("Role", "name", request.getRoleName()));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMobileNo(request.getMobileNo());
        user.setAadhaarNo(request.getAadhaarNo());
        user.setRole(role);
        user.setIsActive(true);
        user.setIsVerified(false);

        userRepository.save(user);

        otpService.generateAndSendOtp(user);

        return new ApiResponse(true, "Registration successful! Please verify your email with OTP.");
    }


    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", request.getEmail()));

        if (!user.getIsActive()) {
            throw new UnauthorizedException("Your account is inactive. Please contact support.");
        }

        String token = tokenProvider.generateToken(authentication);

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getRole().getRoleName(),
                user.getIsVerified()
        );
    }


    @Transactional
    public ApiResponse verifyOtp(OtpVerificationRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", request.getEmail()));

        boolean isValid = otpService.verifyOtp(user, request.getOtpCode());

        if (!isValid) {
            throw new BadRequestException("Invalid or expired OTP");
        }

        user.setIsVerified(true);
        userRepository.save(user);

        return new ApiResponse(true, "Email verified successfully! You can now login.");
    }


    @Transactional
    public ApiResponse resendOtp(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

        if (user.getIsVerified()) {
            throw new BadRequestException("Email is already verified");
        }

        otpService.generateAndSendOtp(user);

        return new ApiResponse(true, "OTP sent successfully to your email");
    }
}