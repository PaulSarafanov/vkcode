package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class GroupDto {
    private Long id;
    private String name;
    private String type;
    private String description;
}
