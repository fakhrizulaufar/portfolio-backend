package com.store.games.controller;

import com.store.games.dto.GameRequest;
import com.store.games.entity.Game;
import com.store.games.service.GameService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Game> create(@Valid @RequestBody GameRequest req) {
        Game game = new Game(null, req.getTitle(), req.getGenre(), req.getPrice(), req.getStock());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(game));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody GameRequest req) {
        Game game = new Game(null, req.getTitle(), req.getGenre(), req.getPrice(), req.getStock());
        return ResponseEntity.ok(service.update(id, game));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/{id}/buy")
    public ResponseEntity<Game> buy(@PathVariable Long id, @RequestParam int qty) {
        return ResponseEntity.ok(service.buy(id, qty));
    }
}
