package com.tcmayowa.gameflix.service;

import com.tcmayowa.gameflix.model.User;
import java.util.List;

public interface UserService {
    String registerUser(User user);
    String loginUser(String username, String password);
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUserById(Long id);
}

