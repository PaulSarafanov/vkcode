package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class ObjDo {
    private Long id;
    private String description;
    private String name;
    private String version;
    private String type;
    private String packageName;
}
