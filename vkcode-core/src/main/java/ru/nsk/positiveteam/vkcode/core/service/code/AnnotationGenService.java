package ru.nsk.positiveteam.vkcode.core.service.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.AnnotationSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.service.data.GroupService;

import java.util.List;


@Service
@AllArgsConstructor
public class AnnotationGenService {
    public static final String FUNCTIOANL_INTERFACE = "FunctionalInterface";
    public static final String FUNCTIOANL_INTERFACE_RESULT = "java.lang.FunctionalInterface";
    private final GroupService groupService;

    public List<AnnotationSpec> generate(ObjDto objDto) {
        //todo доделать генерацию аннотаций
        List<String> annotations = groupService.getAnnotations(objDto.getGroups());
        return annotations.stream()
                .map(className -> {
                    try {
                        return AnnotationSpec.builder(Class.forName(className))
                                .build();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
