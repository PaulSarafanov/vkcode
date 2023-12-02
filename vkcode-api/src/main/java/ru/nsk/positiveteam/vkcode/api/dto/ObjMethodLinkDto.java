package ru.nsk.positiveteam.vkcode.api.dto;

import lombok.Data;

@Data
public class ObjMethodLinkDto {
    private Long id;
    private Long objId;
    private Long methodId;
    private String description;
    private String type;
}
