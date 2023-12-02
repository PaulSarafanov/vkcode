package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class ProgramDto {
    private Long id;
    private String description;
    private String name;
    private String version;
    private String groupId;
}
