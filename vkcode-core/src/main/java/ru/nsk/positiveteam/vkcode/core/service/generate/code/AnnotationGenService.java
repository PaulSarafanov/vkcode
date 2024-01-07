package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.AnnotationSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.AnnotationLinkDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.AnnotationDataService;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;

import java.util.List;


@Service
@AllArgsConstructor
public class AnnotationGenService {
    private final AnnotationDataService annotationDataService;
    private final PackageNameService packageNameService;

    public List<AnnotationSpec> generate(ProgramDto programDto, ObjDto mainObjDto) {
        return annotationDataService.getByObjId(mainObjDto.getId()).stream()
                .map(elem -> generate(programDto, elem))
                .toList();
    }

    protected AnnotationSpec generate(ProgramDto programDto, AnnotationLinkDto linkDto) {
        ObjDto annotationObjDto = annotationDataService.getAnnotationObjDto(linkDto);
        return AnnotationSpec.builder(packageNameService.getClass(programDto, annotationObjDto)).build();
    }
}
