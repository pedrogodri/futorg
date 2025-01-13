package com.br.futorg.api.services.interfaces;

import org.springframework.http.ResponseEntity;

import com.br.futorg.api.model.Aluno;
import com.br.futorg.api.model.Endereco;

public interface IAlunoService {
    ResponseEntity<?> listar();
    ResponseEntity<?> cadastrar(Aluno aluno);
    ResponseEntity<?> editar(Aluno aluno);
    ResponseEntity<?> deletar(Long id);
    ResponseEntity<?> editarEndereco(Long id, Endereco endereco);
}
