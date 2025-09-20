package com.gymManagement.GymMotivation.service;

import com.gymManagement.GymMotivation.dto.UserDto;
import com.gymManagement.GymMotivation.response.AuthResponse;

public interface UserService {
    String signup(UserDto userDto);

    AuthResponse login(UserDto userDto);
}
