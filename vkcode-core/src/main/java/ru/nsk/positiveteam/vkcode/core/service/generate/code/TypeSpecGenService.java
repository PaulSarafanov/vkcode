package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.TypeSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;

import javax.lang.model.element.Modifier;


@Service
@AllArgsConstructor
public class TypeSpecGenService {
    public static final String INNER_CLASS_TYPE = "Inner";
    public static final String INTERFACE_CLASS_TYPE = "Interface";
    public static final String ENUM_CLASS_TYPE = "Enum";
    public static final String CLASS_TYPE = "Class";

    private final MethodGenService methodGenService;

    public TypeSpec generate(ObjDto objDto) {
        TypeSpec.Builder builder = getBuilder(objDto);

        methodGenService.generate(objDto).forEach(builder::addMethod);

        return builder
                .addModifiers(Modifier.PUBLIC)
                .build();
    }

    protected TypeSpec.Builder getBuilder(ObjDto objDto) {
        return switch (objDto.getType()) {
            case INTERFACE_CLASS_TYPE -> TypeSpec.interfaceBuilder(objDto.getClassName());
            case CLASS_TYPE -> TypeSpec.classBuilder(objDto.getClassName());
            case ENUM_CLASS_TYPE -> TypeSpec.enumBuilder(objDto.getClassName());
            case INNER_CLASS_TYPE -> throw new RuntimeException("Не верный тип объекта INNER для генерации!");
            default ->
                    throw new RuntimeException(STR. "Не известный тип объекта \{ objDto.getType() } для генерации!");
        };
    }
}
