package com.tcmayowa.gameflix.service;

import com.tcmayowa.gameflix.model.Review;
import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(Long id);
    Review saveReview(Review review);
    void deleteReviewById(Long id);
}

