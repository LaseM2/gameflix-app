package com.tcmayowa.gameflix;

import com.tcmayowa.gameflix.model.Game;
import com.tcmayowa.gameflix.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadGames(GameRepository gameRepository) {
        return args -> {
            if (gameRepository.count() == 0) { // only add if table is empty
                gameRepository.save(new Game("The Witcher 3", "RPG", 39.99));
                gameRepository.save(new Game("Minecraft", "Sandbox", 26.95));
                gameRepository.save(new Game("FIFA 24", "Sports", 59.99));
                gameRepository.save(new Game("Call of Duty", "FPS", 49.99));
                gameRepository.save(new Game("Cyberpunk 2077", "RPG", 59.99));
                gameRepository.save(new Game("Grand Theft Auto V", "Action", 29.99));
                gameRepository.save(new Game("Fortnite", "Battle Royale", 0.00));
                gameRepository.save(new Game("Overwatch 2", "FPS", 39.99));
                gameRepository.save(new Game("Assassin's Creed Valhalla", "Action", 49.99));
                gameRepository.save(new Game("Stardew Valley", "Simulation", 14.99));
                gameRepository.save(new Game("Hollow Knight", "Platformer", 15.00));
                gameRepository.save(new Game("Among Us", "Party", 4.99));
            }
        };
    }
}

