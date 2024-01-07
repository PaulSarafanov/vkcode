package ru.nsk.positiveteam.vkcode.core.service.generate.javafile;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.JavaFile;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ProgramObjDataService;
import ru.nsk.positiveteam.vkcode.core.service.generate.code.PackageNameService;
import ru.nsk.positiveteam.vkcode.core.service.generate.code.TypeSpecGenService;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

@Service
@AllArgsConstructor
public class JavaFileGenerateService {
    private final ProgramObjDataService programObjDataService;
    private final PackageNameService packageNameService;
    private final TypeSpecGenService typeSpecGenService;

    public void generate(Path path, ProgramDto programDto) {
        generateJavaFiles(programDto).forEach(elem -> {
            try {
                elem.writeTo(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<JavaFile> generateJavaFiles(ProgramDto programDto) {
        return programObjDataService.getObjDtoByProgramId(programDto.getId()).stream()
                .map(objDto -> generateOne(programDto, objDto))
                .toList();
    }

    public JavaFile generateOne(ProgramDto programDto, ObjDto objDto) {
        return JavaFile.builder(packageNameService.getPackageName(programDto, objDto), typeSpecGenService.generate(programDto, objDto))
                .build();
    }
}
