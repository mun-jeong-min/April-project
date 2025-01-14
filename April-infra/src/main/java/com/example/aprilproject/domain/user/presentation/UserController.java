package com.example.aprilproject.domain.user.presentation;

import com.example.aprilproject.domain.user.presentation.dto.UserRequest;
import com.example.aprilproject.domain.user.port.LoginPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final LoginPort loginPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void saveUser(@RequestBody UserRequest request) {
        loginPort.saveUser(request.getName(), request.getPw(), request.getEmail());
    }
}
