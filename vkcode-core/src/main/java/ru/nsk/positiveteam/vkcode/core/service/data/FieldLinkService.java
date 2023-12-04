package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.data.FieldLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ObjDoToObjDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.FieldLinkRepo;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FieldLinkService {
    private ObjRepo objRepo;
    private FieldLinkRepo fieldLinkRepo;
    private ObjDoToObjDtoMapper objDoToObjDtoMapper;

    public List<ObjDto> getAll(Long mainObjId) {
        List<FieldLinkDo> objList = fieldLinkRepo.getByMainObjId(mainObjId);
        return objList.stream()
                .map(elem -> objRepo.getById(elem.getObjId()))
                .map(objDoToObjDtoMapper::mapTo)
                .collect(Collectors.toList());
    }
}
