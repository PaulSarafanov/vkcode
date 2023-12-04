package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ObjDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String className;

    private List<ObjDto> fields;
    private List<GroupDto> groups;
}
