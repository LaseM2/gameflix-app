package com.tcmayowa.gameflix;

import com.tcmayowa.gameflix.model.User;
import com.tcmayowa.gameflix.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers_ShouldReturnList() {
        List<User> users = userService.getAllUsers();
        Assertions.assertNotNull(users, "User list should not be null");
    }

    @Test
    void saveUser_ShouldAddUser() {
        User newUser = new User();
        newUser.setUsername("testuser");
        newUser.setEmail("testuser@example.com");
        newUser.setPassword("password123");

        User savedUser = userService.saveUser(newUser);
        Assertions.assertNotNull(savedUser.getId(), "Saved user should have an ID");

        // Cleanup
        userService.deleteUserById(savedUser.getId());
    }

    @Test
    void getUserById_ShouldReturnUser() {
        User newUser = new User();
        newUser.setUsername("findme");
        newUser.setEmail("findme@example.com");
        newUser.setPassword("password123");

        User savedUser = userService.saveUser(newUser);

        User fetchedUser = userService.getUserById(savedUser.getId());
        Assertions.assertEquals("findme", fetchedUser.getUsername(), "Username should match");

        // Cleanup
        userService.deleteUserById(savedUser.getId());
    }
}

