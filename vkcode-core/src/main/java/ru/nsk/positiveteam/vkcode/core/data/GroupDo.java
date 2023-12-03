package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.JsonDataAware;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.NameAware;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.TypeAware;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.UuidAware;

@Data
public class GroupDo implements UuidAware, NameAware, TypeAware, JsonDataAware {
    private String uuid;
    private String name;
    private String type;
    private String JsonData;
}