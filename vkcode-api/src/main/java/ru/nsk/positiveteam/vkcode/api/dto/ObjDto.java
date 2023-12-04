package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class ObjDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String class_name;
}
