package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ProgramDo;

@Mapper(componentModel = "spring")
public interface ProgramDoToObjDtoMapper extends MapToAware<ProgramDo, ProgramDto> {
}
