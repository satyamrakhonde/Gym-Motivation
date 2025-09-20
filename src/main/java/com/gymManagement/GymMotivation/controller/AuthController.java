package com.gymManagement.GymMotivation.controller;

import com.gymManagement.GymMotivation.dto.LoginDto;
import com.gymManagement.GymMotivation.dto.SignupDto;
import com.gymManagement.GymMotivation.dto.UserDto;
import com.gymManagement.GymMotivation.response.AuthResponse;
import com.gymManagement.GymMotivation.service.AuthService;
import com.gymManagement.GymMotivation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto) {
        UserDto userDto = userService.signup(signupDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
