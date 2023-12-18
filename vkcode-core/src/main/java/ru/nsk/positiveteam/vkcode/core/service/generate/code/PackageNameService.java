package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;

import static org.springframework.util.StringUtils.*;
import static ru.nsk.positiveteam.vkcode.core.service.generate.code.TypeSpecGenService.*;

@Service
@AllArgsConstructor
public class PackageNameService {

    public String getPackageName(ProgramDto programDto, ObjDto objDto) {
        return switch (objDto.getType()) {
            case INTERFACE_CLASS_TYPE -> programDto.getGroupId() + ".generated.api";
            case ANNOTATION_CLASS_TYPE -> programDto.getGroupId() + ".generated.ann";
            case CLASS_TYPE -> programDto.getGroupId() + ".generated.dto";
            case ENUM_CLASS_TYPE -> programDto.getGroupId() + ".generated.enm";
            default -> objDto.getPackageName() + "." + objDto.getName();
        };
    }

    public Class<?> getClass(ProgramDto programDto, ObjDto objDto) {
        String className = getClassNameStr(programDto, objDto);
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassName getClassName(ProgramDto programDto, ObjDto objDto) {
        if (hasText(objDto.getPackageName())) {
            return ClassName.get(objDto.getPackageName(), objDto.getName());
        } else {
            return ClassName.get(getPackageName(programDto, objDto), objDto.getName());
        }
    }

    protected String getClassNameStr(ProgramDto programDto, ObjDto objDto) {
        if (hasText(objDto.getPackageName())) {
            return STR. "\{ objDto.getPackageName() }.\{ objDto.getName() }" ;
        } else {
            return STR. "\{ this.getPackageName(programDto, objDto) }.\{ objDto.getName() }" ;
        }
    }
}
