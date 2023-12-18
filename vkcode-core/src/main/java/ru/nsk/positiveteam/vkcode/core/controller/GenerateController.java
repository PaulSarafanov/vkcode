package ru.nsk.positiveteam.vkcode.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.JavaFile;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.GenerateApi;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ProgramDataService;
import ru.nsk.positiveteam.vkcode.core.service.generate.javafile.JavaFileGenerateService;
import ru.nsk.positiveteam.vkcode.core.service.generate.program.ProgramGenerateService;

import java.nio.file.Path;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class GenerateController implements GenerateApi {
    private ProgramDataService programDataService;
    private JavaFileGenerateService javaFileGenerateService;
    private ProgramGenerateService programGenerateService;

    @Override
    public String generateProgramStr(Long programId) {
        ProgramDto programDto = programDataService.getById(programId);
        if (programDto != null) {
            return javaFileGenerateService.generateJavaFiles(programDto).stream()
                    .map(JavaFile::toString)
                    .reduce((s1, s2) -> s1 + s2)
                    .orElse("No data found!");
        }
        return "No data found!";
    }

    @Override
    public String generateProgram(Long programId) {
        Optional.ofNullable(programDataService.getById(programId))
                .ifPresent(elem -> programGenerateService.generate(Path.of("/temp/" + elem.getName() + "-generated/"), elem));
        return "Done!";
    }
}
