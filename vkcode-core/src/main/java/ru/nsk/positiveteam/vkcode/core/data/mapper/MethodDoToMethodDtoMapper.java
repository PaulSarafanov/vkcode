package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;
import ru.nsk.positiveteam.vkcode.generated.v1.data.MethodDo;

@Mapper(componentModel = "spring")
public interface MethodDoToMethodDtoMapper extends MapToAware<MethodDo, MethodDto> {
}
