package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.data.ProgramDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ProgramDoToObjDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ProgramObjLinkRepo;
import ru.nsk.positiveteam.vkcode.core.data.repo.ProgramRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramDataService {
    private ProgramRepo programRepo;
    private ProgramObjLinkRepo programObjLinkRepo;
    private ProgramDoToObjDtoMapper programDoToObjDtoMapper;
    private ObjService objService;

    public ProgramDto getById(Long programId) {
        ProgramDo programDo = programRepo.getById(programId);
        if (programDo != null) {
            ProgramDto result = programDoToObjDtoMapper.mapTo(programDo);
            result.setObjList(getObjDtoList(programDo));
            return result;
        }
        return null;
    }

    protected List<ObjDto> getObjDtoList(ProgramDo programDo) {
        return programObjLinkRepo.getByProgramId(programDo.getId()).stream()
                .map(elem -> objService.getById(elem.getObjId()))
                .toList();
    }
}
