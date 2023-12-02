package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class ObjFieldLinkDo {
    private Long id;
    private Long mainObjId;
    private Long objId;
    private String description;
    private String name;
    private String type;
}
