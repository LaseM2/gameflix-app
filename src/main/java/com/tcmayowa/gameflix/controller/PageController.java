/*package com.tcmayowa.gameflix.controller;

import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.service.GameService;
import com.tcmayowa.gameflix.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private GameService gameService;

    @Autowired
    private ReviewService reviewService;

    // Welcome page
    @GetMapping("/welcome")
    public String welcomePage(@RequestParam(required = false) String username, Model model) {
        if (username != null) {
            model.addAttribute("username", username);
        }
        return "welcome"; // renders welcome.html
    }

    // Games page
    @GetMapping("/games-page")
    public String gamesPage(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        return "games"; // renders games.html
    }

    // Reviews page - display all reviews
    @GetMapping("/reviews-page")
    public String reviewsPage(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "reviews"; // renders reviews.html
    }

    // Reviews page - handle new review submission
    @PostMapping("/reviews-page")
    public String addReview(@RequestParam String username, @RequestParam String comment) {
        Review review = new Review();
        review.setUsername(username);
        review.setComment(comment);
        reviewService.saveReview(review);
        return "redirect:/reviews-page"; // reload to show the new review
    }
}*/
package com.tcmayowa.gameflix.controller;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.service.GameService;
import com.tcmayowa.gameflix.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private GameService gameService;

    @Autowired
    private ReviewService reviewService;

    // Redirect guest users or other pages to a separate home path
    @GetMapping("/home")
    public String homePage(@RequestParam(required = false) String username, Model model) {
        if (username != null) {
            model.addAttribute("username", username);
        }
        return "welcome"; // renders welcome.html
    }

    // Games page
    /*@GetMapping("/games-page")
    public String gamesPage(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        return "games"; // renders games.html
    }*/
    @GetMapping("/games-page")
    public String gamesPage(Model model) {
        List<Game> games = gameService.getAllGames();
        System.out.println("Games: " + games); // <-- temporary debug
        model.addAttribute("games", games);
        return "games";
    }


    // Reviews page - display all reviews
    @GetMapping("/reviews-page")
    public String reviewsPage(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "reviews"; // renders reviews.html
    }

    // Reviews page - handle new review submission
    @PostMapping("/reviews-page")
    public String addReview(@RequestParam String username, @RequestParam String comment) {
        Review review = new Review();
        review.setUsername(username);
        review.setComment(comment);
        reviewService.saveReview(review);
        return "redirect:/reviews-page"; // reload to show the new review
    }
}
