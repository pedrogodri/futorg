package com.br.futorg.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.br.futorg.api.controllers.interfaces.IAlunoController;
import com.br.futorg.api.model.Aluno;
import com.br.futorg.api.services.AlunoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("aluno")
@Controller
public class AlunoController implements IAlunoController {
   @Autowired
   private AlunoService service;

    @Override
    @GetMapping
    public ResponseEntity<?> listar() {
        return service.listar();
    }

    @Override
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Aluno aluno) {
        return service.cadastrar(aluno);
    }
   
}
