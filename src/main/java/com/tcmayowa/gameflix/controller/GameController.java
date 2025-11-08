/*package com.tcmayowa.gameflix.controller;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Get game details including reviews
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        return gameService.getGameById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a review to a game
    @PostMapping("/{id}/reviews")
    public ResponseEntity<Review> addReview(@PathVariable Long id, @RequestBody Review review) {
        Review savedReview = gameService.addReview(id, review);
        return ResponseEntity.ok(savedReview);
    }
}*/
package com.tcmayowa.gameflix.controller;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    // Add a review to a specific game
    @PostMapping("/{gameId}/reviews")
    public ResponseEntity<Review> addReviewToGame(@PathVariable Long gameId,
                                                  @RequestBody Review review) {
        // Step 1: Validate the game exists and link review
        Review savedReview = gameService.addReview(gameId, review);

        // Step 2: Return the saved review
        return ResponseEntity.ok(savedReview);
    }
}



