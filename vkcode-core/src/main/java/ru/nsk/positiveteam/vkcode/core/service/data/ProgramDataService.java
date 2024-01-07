package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ProgramDoToObjDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ProgramRepo;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ProgramDo;

@Service
@AllArgsConstructor
public class ProgramDataService {
    private ProgramRepo programRepo;
    private ProgramDoToObjDtoMapper programDoToObjDtoMapper;

    public ProgramDto getById(Long programId) {
        ProgramDo programDo = programRepo.getById(programId);
        return programDo != null ? programDoToObjDtoMapper.mapTo(programDo) : null;
    }
}
