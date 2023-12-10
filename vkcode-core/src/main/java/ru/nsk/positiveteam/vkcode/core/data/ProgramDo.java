package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class ProgramDo {
    private Long id;
    private String name;
    private String version;
    private String type;
    private String description;
    private String groupId;
}
