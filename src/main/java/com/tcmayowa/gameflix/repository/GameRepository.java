package com.tcmayowa.gameflix.repository;

import com.tcmayowa.gameflix.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
