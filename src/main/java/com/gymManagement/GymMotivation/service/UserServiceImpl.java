package com.gymManagement.GymMotivation.service;

import com.gymManagement.GymMotivation.dto.UserDto;
import com.gymManagement.GymMotivation.repository.UserRepository;
import com.gymManagement.GymMotivation.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public String signup(UserDto userDto) {
        return "";
    }

    @Override
    public AuthResponse login(UserDto userDto) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User with email "+ username +" not found"));
    }
}
