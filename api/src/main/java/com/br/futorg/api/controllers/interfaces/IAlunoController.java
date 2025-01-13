package com.br.futorg.api.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import com.br.futorg.api.model.Aluno;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface IAlunoController {
    ResponseEntity<?> listar();
    ResponseEntity<?> cadastrar(@RequestBody Aluno aluno);
}
