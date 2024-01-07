package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.core.data.repo.ProgramObjLinkRepo;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ProgramObjLinkDo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramObjDataService {
    private final ProgramObjLinkRepo programObjLinkRepo;
    private ObjDataService objDataService;

    public List<Long> getByProgramId(Long programId) {
        return programObjLinkRepo.getByProgramId(programId).stream()
                .map(ProgramObjLinkDo::getObjId)
                .toList();
    }

    public List<ObjDto> getObjDtoByProgramId(Long programId) {
        return getByProgramId(programId).stream()
                .map(objDataService::getById)
                .toList();

    }
}
