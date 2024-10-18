package com.org.trackpocket.configuration;

import com.org.trackpocket.database_model.Student;
import com.org.trackpocket.database_model.User;
import com.org.trackpocket.repo.StudentRepo;
import com.org.trackpocket.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class AppConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo, UserRepo userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return args -> {
            User user1 = new User("rahul", bCryptPasswordEncoder.encode("R@123"));
            User user2 = new User("tarun", bCryptPasswordEncoder.encode("T@123"));
            User user3 = new User("vivek", bCryptPasswordEncoder.encode("V@123"));
            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            Student s1 = new Student("Rahul", "Raj", "9155881111", "rahul@gmail.com", "India");
            Student s2 = new Student("Vivek", "Dubey", "9876544390", "vivek@gmail.com", "Germany");
            studentRepo.saveAll(Arrays.asList(s1, s2));

            System.out.println("Sample users inserted successfully.");
        };
    }
}