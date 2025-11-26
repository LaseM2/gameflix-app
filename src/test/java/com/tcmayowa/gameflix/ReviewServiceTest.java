package com.tcmayowa.gameflix;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.model.Review;
import com.tcmayowa.gameflix.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    void getAllReviews_ShouldReturnList() {
        List<Review> reviews = reviewService.getAllReviews();
        Assertions.assertNotNull(reviews, "Review list should not be null");
    }

    @Test
    void saveReview_ShouldAddReview() {
        Review newReview = new Review();
        newReview.setUsername("testuser");
        newReview.setComment("This is a test review.");


        Review savedReview = reviewService.saveReview(newReview);
        Assertions.assertNotNull(savedReview.getId(), "Saved review should have an ID");


        reviewService.deleteReviewById(savedReview.getId());
    }

    @Test
    void getReviewById_ShouldReturnReview() {
        Review newReview = new Review();
        newReview.setUsername("findme");
        newReview.setComment("Find this review by ID.");
        // Optional: set a game if required
        // newReview.setGame(someGameObject);

        Review savedReview = reviewService.saveReview(newReview);

        Review fetchedReview = reviewService.getReviewById(savedReview.getId());
        Assertions.assertEquals("findme", fetchedReview.getUsername(), "Username should match");


        reviewService.deleteReviewById(savedReview.getId());
    }
}

