package com.tcmayowa.gameflix.repository;

import com.tcmayowa.gameflix.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
