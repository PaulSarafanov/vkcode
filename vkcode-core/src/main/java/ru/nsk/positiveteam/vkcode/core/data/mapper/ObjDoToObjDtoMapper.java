package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.ToDtoAware;

@Mapper(componentModel = "spring")
public interface ObjDoToObjDtoMapper extends ToDtoAware<ObjDo, ObjDto> {
}
