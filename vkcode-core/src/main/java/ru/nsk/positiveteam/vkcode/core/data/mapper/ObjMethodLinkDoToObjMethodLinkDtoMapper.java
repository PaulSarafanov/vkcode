package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.ObjMethodLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjMethodLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;

@Mapper(componentModel = "spring")
public interface ObjMethodLinkDoToObjMethodLinkDtoMapper extends MapToAware<ObjMethodLinkDo, ObjMethodLinkDto> {
}
