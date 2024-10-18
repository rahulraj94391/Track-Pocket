package com.org.trackpocket.service;

import com.org.trackpocket.model.User;
import com.org.trackpocket.model.UserPrinciple;
import com.org.trackpocket.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            String msg = "User not found with " + username;
            System.out.println(msg);
            throw new UsernameNotFoundException(msg);
        }
        return new UserPrinciple(user);
    }
}
