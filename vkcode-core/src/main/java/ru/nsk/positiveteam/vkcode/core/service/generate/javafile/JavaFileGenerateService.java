package ru.nsk.positiveteam.vkcode.core.service.generate.javafile;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.JavaFile;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.code.JavaCodeGenService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

@Service
@AllArgsConstructor
public class JavaFileGenerateService {
    private final JavaCodeGenService javaCodeGenService;

    public void generate(Path path, ProgramDto dto) {
        Path javaFilePath = path.resolve("src/main/java");

        List<JavaFile> javaFiles =   dto.getObjList().stream()
                .map(objDto -> javaCodeGenService.generate(dto, objDto))
                .toList();

        javaFiles.forEach(elem -> {
            try {
                elem.writeTo(javaFilePath, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
