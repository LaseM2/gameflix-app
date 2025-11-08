/*package com.tcmayowa.gameflix.controller;

import com.tcmayowa.gameflix.model.User;
import com.tcmayowa.gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    // Show registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User()); // empty User object for the form
        return "register"; // this is register.html in templates/
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        String result = userService.registerUser(user);
        model.addAttribute("message", result);

        if (result.equals("User registered successfully")) {
            return "login"; // redirect to login page after successful registration
        }

        return "register"; // stay on register page if there was an error
    }
}*/

package com.tcmayowa.gameflix.controller;

import com.tcmayowa.gameflix.model.User;
import com.tcmayowa.gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // returns register.html from templates/
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        String result = userService.registerUser(user);
        model.addAttribute("message", result);

        if (result.equals("User registered successfully")) {
            return "login"; // redirect to login page
        }
        return "register"; // stay on register page if error
    }
}

