package com.example.aprilproject.domain.user.presentation;

import com.example.aprilproject.domain.user.dto.LoginResponse;
import com.example.aprilproject.domain.user.port.SigninPort;
import com.example.aprilproject.domain.user.presentation.dto.SigninRequest;
import com.example.aprilproject.domain.user.presentation.dto.SignupRequest;
import com.example.aprilproject.domain.user.port.SignupPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final SignupPort signupPort;
    private final SigninPort signinPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void saveUser(@RequestBody SignupRequest request) {
        signupPort.saveUser(request.getName(), request.getPw(), request.getEmail());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResponse login(@RequestBody SigninRequest request) {
        return signinPort.signin(request.getEmail(), request.getPw());
    }
}
