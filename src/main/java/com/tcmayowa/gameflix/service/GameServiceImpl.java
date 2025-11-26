package com.tcmayowa.gameflix.service;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.repository.GameRepository;
import com.tcmayowa.gameflix.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ReviewRepository reviewRepository) {
        this.gameRepository = gameRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Review addReview(Long gameId, Review review) {
        // Fetch the game
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isEmpty()) {
            throw new RuntimeException("Game not found with ID: " + gameId);
        }

        Game game = optionalGame.get();

        // Link review to the game
        review.setGame(game);

        // Save review
        Review savedReview = reviewRepository.save(review);

        // Update game's review set
        game.getReviews().add(savedReview);
        gameRepository.save(game);

        return savedReview;
    }
}


