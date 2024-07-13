package com.br.futorg.api.models.enums;

import lombok.Getter;

@Getter
public enum PositionEnum {
    GOLEIRO("Goleiro"),
    ZAGUEIRO("Zagueiro"),
    LATERAL_D("Lateral Direito"),
    LATERAL_E("Lateral Esquerdo"),
    VOLANTE("Volante"),
    MEIA("Meia"),
    MEIA_E("Sub 9"),
    MEIA_D("Sub 8"),
    MEIA_A("Sub 10"),
    PONTA_E("Sub 7"),
    PONTA_D("Sub 7"),
    SA("Sub 7"),
    CENTROAVANTE("Sub 7");

    private final String status;

    PositionEnum(String status) {
        this.status = status;
    }
}
