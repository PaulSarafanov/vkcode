package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.IdAware;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.JsonDataAware;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.NameAware;
import ru.nsk.positiveteam.vkcode.core.data.aware.data.TypeAware;

@Data
public class GroupDo implements IdAware, NameAware, TypeAware, JsonDataAware {
    private Long id;
    private String name;
    private String type;
    private String JsonData;
}
