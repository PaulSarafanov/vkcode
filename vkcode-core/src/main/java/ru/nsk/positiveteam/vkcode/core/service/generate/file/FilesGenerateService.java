package ru.nsk.positiveteam.vkcode.core.service.generate.file;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;

import java.nio.file.Path;

@Service
@AllArgsConstructor
public class FilesGenerateService {

    public void generate(Path path, ProgramDto dto) {
        //todo
    }
}
