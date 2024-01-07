package ru.nsk.positiveteam.vkcode.core.data.mapper;

import org.mapstruct.Mapper;
import ru.nsk.positiveteam.vkcode.api.dto.AnnotationLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.aware.mapper.MapToAware;
import ru.nsk.positiveteam.vkcode.generated.v1.data.AnnotationLinkDo;

@Mapper(componentModel = "spring")
public interface AnnotationLinkDoToAnnotationLinkDtoMapper extends MapToAware<AnnotationLinkDo, AnnotationLinkDto> {
}
