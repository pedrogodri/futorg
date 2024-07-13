package com.br.futorg.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.futorg.api.models.Message;
import com.br.futorg.api.models.Player;
import com.br.futorg.api.repositories.PlayerRepository;
import com.br.futorg.api.services.interfaces.IPlayerService;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    public PlayerRepository playerRepository;

    @Autowired
    public Message message;

    @Override
    public ResponseEntity<?> createPlayer(Player player) {
        try {
           
            if (player.getName() == null || player.getName().isEmpty()) {
                message.setMessage("O nome do jogador é obrigatório.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (playerRepository.existsByDocumentCpf(player.getDocumentCpf())) {
                message.setMessage("Já existe um jogador com este CPF.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getDocumentCpf() == null || player.getDocumentCpf().isEmpty()) {
                message.setMessage("O CPF do jogador é obrigatório.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getAge() == null) {
                message.setMessage("A idade do jogador é obrigatória.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getBirthDate() == null) {
                message.setMessage("A data de nascimento do jogador é obrigatória.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getSubDivison() == null || player.getSubDivison().isEmpty()) {
                message.setMessage("A subdivisão do jogador é obrigatória.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getWeight() == null) {
                message.setMessage("O peso do jogador é obrigatório.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getHeight() == null) {
                message.setMessage("A altura do jogador é obrigatória.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getPosition() == null || player.getPosition().isEmpty()) {
                message.setMessage("A posição do jogador é obrigatória.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
            if (player.getNationality() == null || player.getNationality().isEmpty()) {
                message.setMessage("A nacionalidade do jogador é obrigatória.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }

            Player savedPlayer = playerRepository.save(player);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
        } catch (Exception e) {
            message.setMessage("Erro ao criar o jogador. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }


    @Override
    public ResponseEntity<?> listAllplayers() {
        try {
            List<Player> players = playerRepository.findAll();
            if(players.isEmpty()) {
                message.setMessage("Não existe nenhum jogador cadastrado no sistema.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            } else {
                return ResponseEntity.ok(players);
            }
            
        } catch (Exception e) {
           message.setMessage("Erro ao listar os jogadores. " + e.getMessage());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message); 
        }
    }

    @Override
    public ResponseEntity<?> updatePlayer(Player player) {
        try {
           if(player.getId() == null) {
            message.setMessage("Id do jogador não informado.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message); 
           }

           if(playerRepository.existsById(player.getId())) {
            Player existPlayer = playerRepository.findByPlayerId(player.getId());

            existPlayer.setName(player.getName());
            existPlayer.setDocumentCpf(player.getDocumentCpf());
            existPlayer.setAge(player.getAge());
            existPlayer.setBirthDate(player.getBirthDate());
            existPlayer.setSubDivison(player.getSubDivison());
            existPlayer.setWeight(player.getWeight());
            existPlayer.setHeight(player.getHeight());
            existPlayer.setPosition(player.getPosition());
            existPlayer.setNationality(player.getNationality());

            return new ResponseEntity<>(existPlayer, HttpStatus.OK);
           } else {
            message.setMessage("Jogador não encontrado.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message); 
           }
        } catch (Exception e) {
            message.setMessage("Erro ao editar o jogador. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message); 
        }
    }

    @Override
    public ResponseEntity<?> deletePlayer(Long id) {
        try {
            if (playerRepository.existsById(id)) {

                Player existPlayer = playerRepository.findByPlayerId(id);
                playerRepository.delete(existPlayer);
                message.setMessage("Deletado");
    
                return new ResponseEntity<>(message, HttpStatus.OK);
            } else {
                message.setMessage("Nenhum cliente encontrado pelo id!");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    
            }
        } catch (Exception e) {
            message.setMessage("Erro ao deletar o jogador. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    @Override
    public ResponseEntity<?> selectPlayerById(Long id) {
        try {
            if (playerRepository.existsById(id)) {

                Player existPlayer = playerRepository.findByPlayerId(id);
    
                return new ResponseEntity<>(existPlayer, HttpStatus.OK);
            } else {
                message.setMessage("Nenhum cliente encontrado pelo id!");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    
            }
        } catch (Exception e) {
            message.setMessage("Erro ao selecionar o jogador. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
}
