package ru.nsk.positiveteam.vkcode.core.service.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.TypeSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.service.data.GroupService;

import javax.lang.model.element.Modifier;


@Service
@AllArgsConstructor
public class TypeSpecGenService {
    public static final String INTERFACE_CLASS = "Interface";
    public static final String ENUM_CLASS = "Enum";
    private final GroupService groupService;
    private final AnnotationGenService annotationGenService;

    public TypeSpec generate(ObjDto objDto) {
        TypeSpec.Builder builder = getBuilder(objDto);

        annotationGenService.generate(objDto)
                .forEach(builder::addAnnotation);
        TypeSpec result = builder
                .addModifiers(Modifier.PUBLIC)
                .build();
        return result;
    }


    protected TypeSpec.Builder getBuilder(ObjDto objDto) {
        String classType = groupService.getClassType(objDto.getGroups());
        return switch (classType) {
            case INTERFACE_CLASS -> TypeSpec.interfaceBuilder(objDto.getClassName());
            case ENUM_CLASS -> TypeSpec.enumBuilder(objDto.getClassName());
            default -> TypeSpec.classBuilder(objDto.getClassName());
        };
    }
}
