package com.tcmayowa.gameflix.service;

import com.tcmayowa.gameflix.model.User;
import com.tcmayowa.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /*@Override
    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }*/
    @Override
    public String registerUser(User user) {
        // Check if username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists";
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default values for required fields if null or empty
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            user.setEmail(user.getUsername() + "@example.com"); // or any default
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            user.setName(user.getUsername()); // default name = username
        }
        if (user.getSubType() == null) {
            user.setSubType(""); // optional field
        }

        // Save user to database
        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User saveUser(User user) { return userRepository.save(user); }

    @Override
    public void deleteUserById(Long id) { userRepository.deleteById(id); }

    @Override
    public String loginUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Login successful";
            }
        }
        return "Invalid username or password";
    }

}


