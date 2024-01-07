package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.AnnotationLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.mapper.AnnotationLinkDoToAnnotationLinkDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.AnnotationLinkRepo;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.generated.v1.data.AnnotationLinkDo;

import java.util.List;

@Service
@AllArgsConstructor
public class AnnotationDataService {
    private final AnnotationLinkRepo annotationLinkRepo;
    private final ObjDataService objDataService;

    private final AnnotationLinkDoToAnnotationLinkDtoMapper mapper;

    public List<AnnotationLinkDto> getByObjId(Long mainObjId) {
        List<AnnotationLinkDo> list = annotationLinkRepo.getByMainObjId(mainObjId);
        return list.stream()
                .map(mapper::mapTo)
                .toList();
    }

    public ObjDto getAnnotationObjDto(AnnotationLinkDto linkDto) {
        return objDataService.getById(linkDto.getObjId());
    }
}
