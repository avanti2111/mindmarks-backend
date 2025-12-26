package com.mindmarks.mindmarks.services;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mindmarks.mindmarks.dto.RegisterRequest;
import com.mindmarks.mindmarks.entity.User;
import com.mindmarks.mindmarks.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {

    // 1. Check if user already exists
    if (userRepository.existsByEmail(request.getEmail())) {
        throw new IllegalArgumentException("Email already registered");
    }

    // 2. Validate password
    if (request.getPassword().length() < 8) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password must be at least 8 characters");
    }

    // 3. Create User entity
    User user = new User();
    user.setEmail(request.getEmail());

    // 4. Encode password
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    // 5. Save user
    userRepository.save(user);
  }

  public User authenticate(String email, String rawPassword) {

    User user = userRepository.findByEmail(email)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid credentials"
                )
            );

    if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
        throw new ResponseStatusException(
            HttpStatus.UNAUTHORIZED,
            "Invalid credentials"
        );
    }

    return user;
}

}