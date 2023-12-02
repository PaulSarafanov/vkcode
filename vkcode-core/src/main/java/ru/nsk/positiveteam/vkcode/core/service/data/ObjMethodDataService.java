package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjMethodLinkDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjMethodLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ObjMethodLinkDoToObjMethodLinkDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjMethodLinkRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ObjMethodDataService {
    private final ObjMethodLinkRepo objMethodLinkRepo;
    private final MethodDataService methodDataService;
    private final ObjMethodLinkDoToObjMethodLinkDtoMapper mapper;

    public List<ObjMethodLinkDto> getByMainObjId(Long mainObjId) {
        List<ObjMethodLinkDo> list = objMethodLinkRepo.getByObjId(mainObjId);
        return list.stream()
                .map(mapper::mapTo)
                .toList();
    }

    public MethodDto getByObjMethodLinkDto(ObjMethodLinkDto linkDo) {
        return methodDataService.getById(linkDo.getMethodId());
    }
}
