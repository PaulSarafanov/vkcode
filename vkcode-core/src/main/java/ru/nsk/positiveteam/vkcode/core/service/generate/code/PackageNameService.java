package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;

import static org.springframework.util.StringUtils.hasText;
import static ru.nsk.positiveteam.vkcode.core.service.generate.code.TypeSpecGenService.ANNOTATION_CLASS_TYPE;
import static ru.nsk.positiveteam.vkcode.core.service.generate.code.TypeSpecGenService.CLASS_TYPE;
import static ru.nsk.positiveteam.vkcode.core.service.generate.code.TypeSpecGenService.ENUM_CLASS_TYPE;
import static ru.nsk.positiveteam.vkcode.core.service.generate.code.TypeSpecGenService.INTERFACE_CLASS_TYPE;

@Service
@AllArgsConstructor
public class PackageNameService {

    public String getPackageName(ProgramDto programDto, ObjDto objDto) {
        if (hasText(objDto.getPackageName())) {
            return objDto.getPackageName();
        }
        String version = getVersion(objDto);
        String basePackage = programDto.getGroupId() + "." + programDto.getName().toLowerCase() + ".generated" + version;
        String addPackage = getAddPackage(objDto);
        return switch (objDto.getType()) {
            case INTERFACE_CLASS_TYPE -> basePackage + (hasText(addPackage) ? addPackage : ".api");
            case ANNOTATION_CLASS_TYPE -> basePackage + ".ann";
            case CLASS_TYPE -> basePackage + addPackage;
            case ENUM_CLASS_TYPE -> basePackage + ".enm";
            default -> basePackage;
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
        return ClassName.get(getPackageName(programDto, objDto), objDto.getName());
    }

    protected String getClassNameStr(ProgramDto programDto, ObjDto objDto) {
        return this.getPackageName(programDto, objDto) + "." + objDto.getName();
    }

    protected String getVersion(ObjDto objDto) {
        return hasText(objDto.getVersion()) ? ".v" + objDto.getVersion() : "";
    }

    protected String getAddPackage(ObjDto objDto) {
        return hasText(objDto.getAddPackageName()) ? "." + objDto.getAddPackageName() : "";
    }
}
