package com.br.futorg.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.futorg.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
