package com.br.futorg.api.models.enums;

import lombok.Getter;

@Getter
public enum SubDivisonEnum {
    SUB7("Sub 7"),
    SUB8("Sub 8"),
    SUB9("Sub 9"),
    SUB10("Sub 10"),
    SUB11("Sub 11"),
    SUB12("Sub 12"),
    SUB13("Sub 13"),
    SUB14("Sub 14"),
    SUB15("Sub 15"),
    SUB16("Sub 16");

    private final String status;

    SubDivisonEnum(String status) {
        this.status = status;
    }
}
