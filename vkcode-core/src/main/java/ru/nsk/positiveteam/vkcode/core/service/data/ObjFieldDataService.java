package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjFieldLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjFieldLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ObjFieldLinkDoToObjFieldLinkDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjFieldLinkRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ObjFieldDataService {
    private final ObjFieldLinkRepo objFieldLinkRepo;
    private final ObjDataService objDataService;

    private final ObjFieldLinkDoToObjFieldLinkDtoMapper mapper;

    public List<ObjFieldLinkDto> getByObjId(Long mainObjId) {
        List<ObjFieldLinkDo> list = objFieldLinkRepo.getByMainObjId(mainObjId);
        return list.stream()
                .map(mapper::mapTo)
                .toList();
    }

    public ObjDto getByObjFieldLinkDto(ObjFieldLinkDto linkDo) {
        return objDataService.getById(linkDo.getObjId());
    }
}
