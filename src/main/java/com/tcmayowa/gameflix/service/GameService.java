package com.tcmayowa.gameflix.service;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;

import java.util.List;
import java.util.Optional;

public interface GameService {

    // Get all games
    List<Game> getAllGames();

    // Get a game by its ID
    Optional<Game> getGameById(Long id);

    // Save a new game or update an existing one
    Game saveGame(Game game);

    // Add a review to a game
    Review addReview(Long gameId, Review review);
}
