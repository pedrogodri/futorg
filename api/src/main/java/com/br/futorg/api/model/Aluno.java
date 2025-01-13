package com.br.futorg.api.model;

import java.util.List;

import com.br.futorg.api.model.enums.PernaBoaEnum;
import com.br.futorg.api.model.enums.PosicaoEnum;
import com.br.futorg.api.model.enums.SubDivisaoEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alunos")
@Getter
@Setter
public class Aluno extends Pessoa {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "aluno_posicoes", joinColumns = @JoinColumn(name = "aluno_id"))
    private List<PosicaoEnum> posicoes;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "aluno_sub_divisoes", joinColumns = @JoinColumn(name = "aluno_id"))
    private List<SubDivisaoEnum> subDivisao;

    @Column(name = "perna_ruim")
    @Min(0)
    @Max(5)
    @NotNull
    private Integer pernaRuim;

    @Column(name = "perna_boa")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PernaBoaEnum pernaBoa;

    @Min(0)
    @Max(5)
    private Integer fintas;
    @NotNull
    private Double altura;
    @NotNull
    private Double peso;
    
    @Column(name = "classificacao_geral")
    private Double classificacaoGeral;

    @Column(name = "classificacao_ritmo")
    private Double classificacaoRitmo;

    @Column(name = "classificacao_finalizacao")
    private Double classificacaoFinalizacao;

    @Column(name = "classificacao_passe")
    private Double classificacaoPasse;

    @Column(name = "classificacao_conducao")
    private Double classificacaoConducao;

    @Column(name = "classificacao_defesa")
    private Double classificacaoDefesa;

    @Column(name = "classificacao_fisico")
    private Double classificacaoFisico;
}