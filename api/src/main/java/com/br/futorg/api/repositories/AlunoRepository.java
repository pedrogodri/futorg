package com.br.futorg.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.futorg.api.model.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("SELECT COUNT(a) > 0 FROM Aluno a WHERE a.email = :email")
    boolean findByEmail(String email);
    @Query("SELECT COUNT(a) > 0 FROM Aluno a WHERE a.cpf = :cpf")
    boolean findByCpf(String cpf);
}
