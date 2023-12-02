package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.ObjFieldLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjFieldLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;

@Mapper(componentModel = "spring")
public interface ObjFieldLinkDoToObjFieldLinkDtoMapper extends MapToAware<ObjFieldLinkDo, ObjFieldLinkDto> {
}
