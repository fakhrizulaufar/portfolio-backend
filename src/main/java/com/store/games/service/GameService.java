package com.store.games.service;

import com.store.games.entity.Game;
import com.store.games.exception.NotFoundException;
import com.store.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.*;

import java.util.List;

@Service
public class GameService {

    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private GameRepository repo;

    @Cacheable("games")
    public List<Game> getAll() {
        log.info("GET ALL GAMES");
        return repo.findAll();
    }

    public Game getById(Long id) {
        log.info("GET GAME ID {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Game tidak ditemukan"));
    }

    public Game create(Game game) {
        log.info("CREATE GAME {}", game.getTitle());
        return repo.save(game);
    }

    public Game update(Long id, Game newGame) {
        Game game = getById(id);

        game.setTitle(newGame.getTitle());
        game.setGenre(newGame.getGenre());
        game.setPrice(newGame.getPrice());
        game.setStock(newGame.getStock());

        return repo.save(game);
    }

    public void delete(Long id) {
        log.info("DELETE GAME {}", id);
        repo.deleteById(id);
    }

    public Game buy(Long id, int qty) {
        Game game = getById(id);

        if (game.getStock() < qty) {
            throw new RuntimeException("Stock tidak cukup");
        }

        game.setStock(game.getStock() - qty);
        return repo.save(game);
    }
}
