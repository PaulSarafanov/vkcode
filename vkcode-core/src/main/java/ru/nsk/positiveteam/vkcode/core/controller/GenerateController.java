package ru.nsk.positiveteam.vkcode.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.GenerateApi;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.code.JavaCodeGenService;
import ru.nsk.positiveteam.vkcode.core.service.data.ProgramDataService;
import ru.nsk.positiveteam.vkcode.core.service.generate.program.ProgramGenerateService;

import java.nio.file.Path;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class GenerateController implements GenerateApi {
    private ProgramDataService programDataService;
    private JavaCodeGenService javaCodeGenService;
    private ProgramGenerateService programGenerateService;

    @Override
    public String generateProgramStr(Long programId) {
        ProgramDto programDto = programDataService.getById(programId);

        return programDto != null ? javaCodeGenService.generate(programDto, programDto.getObjList().get(0)).toString() : "Not Found";
    }

    @Override
    public String generateProgram(Long programId) {
        Optional.ofNullable(programDataService.getById(programId))
                .ifPresent(elem -> programGenerateService.generate(Path.of("/temp/"), elem));
        return "Done!";
    }
}
