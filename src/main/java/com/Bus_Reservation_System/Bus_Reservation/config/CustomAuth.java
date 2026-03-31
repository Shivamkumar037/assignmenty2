package com.Bus_Reservation_System.Bus_Reservation.config;

import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.repository.UserReop;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CustomAuth implements UserDetailsService {
private  final UserReop userReop;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userReop.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return user;
    }

}
