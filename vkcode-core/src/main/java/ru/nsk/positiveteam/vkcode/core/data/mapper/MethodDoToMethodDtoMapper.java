package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.core.data.MethodDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;

@Mapper(componentModel = "spring")
public interface MethodDoToMethodDtoMapper extends MapToAware<MethodDo, MethodDto> {
}
