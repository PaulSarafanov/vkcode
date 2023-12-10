package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class ObjDto {
    private Long id;
    private String description;
    private String name;
    private Integer version;
    private String type;
    private String className;
}
