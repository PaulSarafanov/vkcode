package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class AnnotationLinkDo {
    private Long id;
    private Long mainObjId;
    private Long objId;
    private String type;
}
