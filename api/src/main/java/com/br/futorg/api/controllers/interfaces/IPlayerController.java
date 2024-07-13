package com.br.futorg.api.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.futorg.api.models.Player;

public interface IPlayerController {
    ResponseEntity<?> createPlayer(@RequestBody Player player);
    ResponseEntity<?> listAllplayers();
    ResponseEntity<?> updatePlayer(@RequestBody Player player);
    ResponseEntity<?> deletePlayer(@PathVariable Long id);
    ResponseEntity<?> selectPlayerById(@PathVariable Long id);
}
