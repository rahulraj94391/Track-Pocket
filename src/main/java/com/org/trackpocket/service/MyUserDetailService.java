package com.org.trackpocket.service;

import com.org.trackpocket.database_model.User;
import com.org.trackpocket.model.UserPrinciple;
import com.org.trackpocket.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            String msg = "User not found with " + username;
            logger.error(msg);
            throw new UsernameNotFoundException(msg);
        }
        return new UserPrinciple(user);
    }
}
