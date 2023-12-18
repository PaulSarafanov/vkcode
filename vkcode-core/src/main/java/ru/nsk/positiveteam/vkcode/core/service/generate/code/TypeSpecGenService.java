package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.TypeSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;

import javax.lang.model.element.Modifier;


@Service
@AllArgsConstructor
public class TypeSpecGenService {
    public static final String INNER_CLASS_TYPE = "Inner";
    public static final String INTERFACE_CLASS_TYPE = "interface";
    public static final String ANNOTATION_CLASS_TYPE = "@interface";
    public static final String ENUM_CLASS_TYPE = "enum";
    public static final String CLASS_TYPE = "class";

    private final PackageNameService packageNameService;
    private final MethodGenService methodGenService;
    private final FieldGenService fieldGenService;
    private final AnnotationGenService annotationGenService;

    public TypeSpec generate(ProgramDto programDto, ObjDto objDto) {
        TypeSpec.Builder builder = getBuilder(programDto, objDto);
        annotationGenService.generate(programDto, objDto).forEach(builder::addAnnotation);
        fieldGenService.generate(programDto, objDto).forEach(builder::addField);
        methodGenService.generate(programDto, objDto).forEach(builder::addMethod);

        return builder
                .addModifiers(Modifier.PUBLIC)
                .build();
    }

    protected TypeSpec.Builder getBuilder(ProgramDto programDto, ObjDto objDto) {
        return switch (objDto.getType()) {
            case INTERFACE_CLASS_TYPE -> TypeSpec.interfaceBuilder(packageNameService.getClassName(programDto, objDto));
            case ANNOTATION_CLASS_TYPE ->
                    TypeSpec.annotationBuilder(packageNameService.getClassName(programDto, objDto));
            case CLASS_TYPE -> TypeSpec.classBuilder(packageNameService.getClassName(programDto, objDto));
            case ENUM_CLASS_TYPE -> TypeSpec.enumBuilder(packageNameService.getClassName(programDto, objDto));
            case INNER_CLASS_TYPE -> throw new RuntimeException("Не верный тип объекта INNER для генерации!");
            default ->
                    throw new RuntimeException("Не известный тип объекта " + objDto.getType() + " для генерации!" );
        };
    }
}
