package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class MethodDo {
    private Long id;
    private String description;
    private String name;
    private Long version;
    private String type;
    private Long returnObjId;
}
