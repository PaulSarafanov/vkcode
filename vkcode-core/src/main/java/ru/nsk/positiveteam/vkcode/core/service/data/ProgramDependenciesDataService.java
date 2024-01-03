package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.data.ProgramDependenciesLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.repo.ProgramDependenciesLinkRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramDependenciesDataService {
    private final ProgramDependenciesLinkRepo programDependenciesLinkRepo;
    private ProgramDataService programDataService;

    public List<Long> getByProgramId(Long programId) {
        return programDependenciesLinkRepo.getByProgramId(programId).stream()
                .map(ProgramDependenciesLinkDo::getDependencyProgramId)
                .toList();
    }

    public List<ProgramDto> getObjDtoByProgramId(Long programId) {
        return getByProgramId(programId).stream()
                .map(programDataService::getById)
                .toList();

    }
}
