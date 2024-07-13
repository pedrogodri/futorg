package com.br.futorg.api.services.interfaces;


import org.springframework.http.ResponseEntity;

import com.br.futorg.api.models.Player;

public interface IPlayerService {
    ResponseEntity<?> createPlayer (Player player);
    ResponseEntity<?> listAllplayers();
    ResponseEntity<?> updatePlayer(Player player);
    ResponseEntity<?> deletePlayer(Long id);
    ResponseEntity<?> selectPlayerById(Long id);
}
