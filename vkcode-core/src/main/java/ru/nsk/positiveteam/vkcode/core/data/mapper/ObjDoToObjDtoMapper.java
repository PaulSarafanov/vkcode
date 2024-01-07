package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ObjDo;

@Mapper(componentModel = "spring")
public interface ObjDoToObjDtoMapper extends MapToAware<ObjDo, ObjDto> {
}
