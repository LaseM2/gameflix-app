/*package com.tcmayowa.gameflix;

import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.repository.ReviewRepository;
import com.tcmayowa.gameflix.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewDataLoader {

    @Bean
    CommandLineRunner loadReviews(ReviewRepository reviewRepository, GameRepository gameRepository) {
        return args -> {
            if (reviewRepository.count() == 0) {
                // Fetch a game to optionally link reviews
                Game witcher = gameRepository.findAll().stream()
                        .filter(g -> g.getTitle().equals("The Witcher 3"))
                        .findFirst()
                        .orElse(null);

                reviewRepository.save(new Review("Alice", "Amazing RPG!", witcher));
                reviewRepository.save(new Review("Bob", "Loved the storyline.", witcher));
                reviewRepository.save(new Review("Charlie", "Not my type.", null));
                reviewRepository.save(new Review("Dana", "Great graphics!", null));
            }
        };
    }
}*/

package com.tcmayowa.gameflix;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.repository.GameRepository;
import com.tcmayowa.gameflix.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewDataLoader {

    @Bean
    CommandLineRunner loadReviews(GameRepository gameRepository, ReviewRepository reviewRepository) {
        return args -> {
            if (reviewRepository.count() == 0) {
                // Fetch some games to attach reviews to
                Game witcher = gameRepository.findById(1L).orElse(null);
                Game minecraft = gameRepository.findById(2L).orElse(null);

                if (witcher != null) {
                    Review review1 = new Review();
                    review1.setUsername("Alice");
                    review1.setComment("Absolutely amazing RPG!");
                    review1.setGame(witcher);
                    reviewRepository.save(review1);

                    Review review2 = new Review();
                    review2.setUsername("Bob");
                    review2.setComment("Loved the storyline and graphics.");
                    review2.setGame(witcher);
                    reviewRepository.save(review2);
                }

                if (minecraft != null) {
                    Review review3 = new Review();
                    review3.setUsername("Charlie");
                    review3.setComment("Endless creativity!");
                    review3.setGame(minecraft);
                    reviewRepository.save(review3);
                }
            }
        };
    }
}
