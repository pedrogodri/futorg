package com.br.futorg.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.futorg.api.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT player FROM Cliente player WHERE player.id = :id")
    Player findByPlayerId(Long id);
    Optional<Player> findById(long id);
    Optional<Player> findByDocumentCpf(String documentCpf);
    boolean existsByDocumentCpf(String documentCpf);
    boolean existsById(Long id);
}
