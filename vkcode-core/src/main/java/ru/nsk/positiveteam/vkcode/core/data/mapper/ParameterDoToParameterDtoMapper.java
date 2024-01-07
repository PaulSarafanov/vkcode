package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.ParameterDto;
import ru.nsk.positiveteam.vkcode.core.data.ParameterDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;

@Mapper(componentModel = "spring")
public interface ParameterDoToParameterDtoMapper extends MapToAware<ParameterDo, ParameterDto> {
}
