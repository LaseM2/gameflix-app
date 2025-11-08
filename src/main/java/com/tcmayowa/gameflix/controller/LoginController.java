/*package com.tcmayowa.gameflix.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // GET mapping for login page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // returns login.html from templates/
    }

    // GET mapping for welcome page
    @GetMapping("/welcome")
    public String welcomePage(Model model, Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName(); // gets logged-in username
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", "Guest");
        }
        return "welcome"; // returns welcome.html from templates/
    }
}*/
package com.tcmayowa.gameflix.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // GET mapping for login page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // returns login.html from templates/
    }

    // GET mapping for welcome page after login
    @GetMapping("/welcome")
    public String welcomePage(Model model, Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName(); // gets logged-in username
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", "Guest");
        }
        return "welcome"; // returns welcome.html from templates/
    }
}

