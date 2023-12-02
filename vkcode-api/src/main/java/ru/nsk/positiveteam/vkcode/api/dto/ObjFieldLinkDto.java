package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class ObjFieldLinkDto {
    private Long id;
    private Long mainObjId;
    private Long objId;
    private String description;
    private String name;
    private String type;
}
