package com.br.futorg.api.models;

import com.br.futorg.api.models.enums.PositionEnum;
import com.br.futorg.api.models.enums.SubDivisonEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    public String name;
    
    @Column(name = "documentCpf", nullable = false)
    public String documentCpf;

    @Column(name = "age", nullable = false)
    public Integer age;

    @Column(name = "birthDate", nullable = false)
    public Date birthDate;

    @ElementCollection(targetClass = SubDivisonEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "player_subdivisions", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "sub_divison", nullable = false)
    private Set<SubDivisonEnum> subDivison;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "height", nullable = false)
    private Float height;

    @ElementCollection(targetClass = PositionEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "player_positions", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "position", nullable = false)
    private Set<PositionEnum> position;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<UserPlayer> userPlayers;
}
