package com.org.trackpocket.service;

import com.org.trackpocket.database_model.User;
import com.org.trackpocket.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager autManager;
    private final JWTService jwtService;
    private final UserRepo userRepo;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public User register(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    public String verify(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = autManager.authenticate(token);
        String jwtToken;
        if (authenticate.isAuthenticated()) {
            jwtToken = jwtService.generateToken(user.getUsername());
        } else {
            logger.error("Cannot verify user: {}", user);
            jwtToken = "";
        }
        return jwtToken;
    }
}
