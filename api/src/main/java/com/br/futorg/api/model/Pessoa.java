package com.br.futorg.api.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@Component
public class Pessoa {
    @NotNull
    public String nome;
    @NotNull
    @CPF
    public String cpf;
    @NotNull
    public Integer idade;
    @NotNull
    public LocalDate dataNascimento;
    @NotNull
    public String email;

    @OneToOne
    public Endereco endereco;
}
