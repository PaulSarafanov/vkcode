package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class ParameterDto {
    private Long id;
    private Long methodId;
    private Long objId;
    private String name;
    private Integer num;
}
