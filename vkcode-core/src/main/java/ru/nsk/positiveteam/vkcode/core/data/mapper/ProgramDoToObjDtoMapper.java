package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.data.ProgramDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.ToDtoAware;

@Mapper(componentModel = "spring")
public interface ProgramDoToObjDtoMapper extends ToDtoAware<ProgramDo, ProgramDto> {
}
