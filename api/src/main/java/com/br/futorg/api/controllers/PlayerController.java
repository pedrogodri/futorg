package com.br.futorg.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.br.futorg.api.controllers.interfaces.IPlayerController;
import com.br.futorg.api.models.Player;
import com.br.futorg.api.services.PlayerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/player")
public class PlayerController implements IPlayerController {

    @Autowired
    public PlayerService playerService;

    @PostMapping()
    @Override
    public ResponseEntity<?> createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping() 
    @Override
    public ResponseEntity<?> listAllplayers() {
        return playerService.listAllplayers();
    }

    @PutMapping()
    @Override
    public ResponseEntity<?> updatePlayer(Player player) {
        return playerService.updatePlayer(player);
    }

    @Override
    public ResponseEntity<?> deletePlayer(Long id) {
        return playerService.deletePlayer(id);
    }

    @Override
    public ResponseEntity<?> selectPlayerById(Long id) {
        return playerService.selectPlayerById(id);
    }
    
}
