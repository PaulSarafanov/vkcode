package ru.nsk.positiveteam.vkcode.core.service.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.JavaFile;
import org.springframework.javapoet.TypeSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;


@Service
@AllArgsConstructor
public class JavaCodeGenService {
    private final PackageNameService packageNameService;
    private final TypeSpecGenService typeSpecGenService;

    public JavaFile generate(ProgramDto dto, ObjDto objDto) {
        TypeSpec typeSpec = typeSpecGenService.generate(objDto);

        return JavaFile.builder(packageNameService.getPackageName(dto, objDto), typeSpec)
                .build();
    }
}
