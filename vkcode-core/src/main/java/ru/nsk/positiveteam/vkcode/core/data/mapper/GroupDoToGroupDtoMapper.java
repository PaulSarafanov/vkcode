package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.GroupDto;
import ru.nsk.positiveteam.vkcode.core.data.GroupDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.ToDtoAware;

@Mapper(componentModel = "spring")
public interface GroupDoToGroupDtoMapper extends ToDtoAware<GroupDo, GroupDto> {
}
