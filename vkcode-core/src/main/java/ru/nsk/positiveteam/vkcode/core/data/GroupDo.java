package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class GroupDo {
    private Long id;
    private String name;
    private String type;
    private String description;
}
