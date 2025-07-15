package com.example.ecommerce.controller;

import com.example.ecommerce.model.AuthRequest;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        userRepo.save(user);
        return "User registered!";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        User user = userRepo.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(authRequest.getPassword()))
            throw new RuntimeException("Invalid credentials");
        return jwtUtil.generateToken(user);
    }
}
