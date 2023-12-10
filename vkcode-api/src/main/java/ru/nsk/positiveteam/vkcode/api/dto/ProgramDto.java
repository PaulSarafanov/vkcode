package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProgramDto {
    private Long id;
    private String name;
    private String version;
    private String type;
    private String description;
    private String groupId;

    private List<ObjDto> objList;
    private List<GroupDto> groups;
}
