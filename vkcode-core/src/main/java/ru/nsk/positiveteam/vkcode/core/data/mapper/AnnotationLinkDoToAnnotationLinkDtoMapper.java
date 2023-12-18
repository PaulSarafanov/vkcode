package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.AnnotationLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.AnnotationLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;

@Mapper(componentModel = "spring")
public interface AnnotationLinkDoToAnnotationLinkDtoMapper extends MapToAware<AnnotationLinkDo, AnnotationLinkDto> {
}
