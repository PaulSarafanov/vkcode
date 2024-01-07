package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class ParameterDo {
    private Long id;
    private Long methodId;
    private Long objId;
    private String name;
    private Integer num;
}
