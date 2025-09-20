package com.gymManagement.GymMotivation.service;

import com.gymManagement.GymMotivation.dto.SignupDto;
import com.gymManagement.GymMotivation.dto.UserDto;
import com.gymManagement.GymMotivation.response.AuthResponse;

public interface UserService {
    UserDto signup(SignupDto userDto);

    AuthResponse login(SignupDto userDto);
}
