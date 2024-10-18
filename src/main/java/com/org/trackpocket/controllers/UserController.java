package com.org.trackpocket.controllers;

import com.org.trackpocket.model.User;
import com.org.trackpocket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User userRegistered = userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRegistered);
    }
}
