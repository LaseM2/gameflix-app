package com.tcmayowa.gameflix;

import com.tcmayowa.gameflix.model.User;
import com.tcmayowa.gameflix.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers_ShouldReturnList() {
        List<User> users = userService.getAllUsers();
        Assertions.assertNotNull(users, "User list should not be null");
    }

    @Test
    void registerUser_ShouldAddUser() {
        User newUser = new User();
        newUser.setUsername("testuser");
        newUser.setPassword("password123"); // password will be encoded
        // no need to set email or name; registerUser() sets defaults

        String result = userService.registerUser(newUser);
        Assertions.assertEquals("User registered successfully", result);

        // Verify user exists
        List<User> users = userService.getAllUsers();
        boolean exists = users.stream().anyMatch(u -> u.getUsername().equals("testuser"));
        Assertions.assertTrue(exists, "User should exist after registration");
    }

    @Test
    void getUserById_ShouldReturnUser() {
        // Register a new user
        User newUser = new User();
        newUser.setUsername("findme");
        newUser.setPassword("password123");
        userService.registerUser(newUser);

        // Fetch the user by username first to get ID
        User savedUser = userService.getAllUsers().stream()
                .filter(u -> u.getUsername().equals("findme"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        User fetchedUser = userService.getUserById(savedUser.getId());
        Assertions.assertEquals("findme", fetchedUser.getUsername(), "Username should match");
    }
}
