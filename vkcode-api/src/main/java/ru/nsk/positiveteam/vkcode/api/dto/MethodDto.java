package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class MethodDto {
    private Long id;
    private String description;
    private String name;
    private Long version;
    private String type;
    private Long returnObjId;
}
