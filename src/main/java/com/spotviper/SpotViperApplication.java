package com.spotviper;

import com.spotviper.entities.User;
import com.spotviper.entities.enums.Role;
import com.spotviper.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotViperApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public SpotViperApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpotViperApplication.class, args);
        System.out.println("SpotViperApplication started successfully.");
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByEmail("john.doe@example.com")) {
            User user = new User("johndoe", "john.doe@example.com",
                    "{noop}changeme", "John Doe", Role.USER, "key");
            System.out.println(userRepository.save(user));
        }
    }
}
