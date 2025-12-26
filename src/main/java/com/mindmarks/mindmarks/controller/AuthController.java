package com.mindmarks.mindmarks.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindmarks.mindmarks.dto.AuthResponse;
import com.mindmarks.mindmarks.dto.LoginRequest;
import com.mindmarks.mindmarks.dto.RegisterRequest;
import com.mindmarks.mindmarks.entity.User;
import com.mindmarks.mindmarks.security.JwtUtil;
import com.mindmarks.mindmarks.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/1/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            userService.register(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {

        User user = userService.authenticate(req.getEmail(), req.getPassword());
        String token = jwtUtil.generateToken(user);

        return new AuthResponse(token);
    }
}

