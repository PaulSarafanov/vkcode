package ru.nsk.positiveteam.vkcode.core.service.generate.program;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.generate.file.FilesGenerateService;
import ru.nsk.positiveteam.vkcode.core.service.generate.javafile.JavaFileGenerateService;
import ru.nsk.positiveteam.vkcode.core.service.generate.pom.PomGenerateService;

import java.nio.file.Path;

@Service
@AllArgsConstructor
public class ProgramGenerateService {
    private final JavaFileGenerateService javaFileGenerateService;
    private final FilesGenerateService filesGenerateService;
    private final PomGenerateService pomGenerateService;

    public void generate(Path path, ProgramDto dto) {
        pomGenerateService.generate(path, dto);
        filesGenerateService.generate(path, dto);
        javaFileGenerateService.generate(path, dto);
    }
}
