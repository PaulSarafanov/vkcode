package ru.nsk.positiveteam.vkcode.core.service.generate.program;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.generate.javafile.JavaFileGenerateService;
import ru.nsk.positiveteam.vkcode.core.service.generate.pom.PomGeneratedService;

import java.nio.file.Path;

@Service
@AllArgsConstructor
public class ProgramGenerateService {
    private final JavaFileGenerateService javaFileGenerateService;
    private final PomGeneratedService pomGeneratedService;

    public void generate(Path path, ProgramDto dto) {
        pomGeneratedService.generate(path, dto);
        javaFileGenerateService.generate(path.resolve("src/main/java"), dto);
    }
}
