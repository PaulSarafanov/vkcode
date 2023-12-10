package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ObjDoToObjDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjRepo;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ObjService {
    private ObjRepo objRepo;
    private ObjDoToObjDtoMapper objDoToObjDtoMapper;
    private FieldLinkService fieldLinkService;
    private GroupLinkService groupLinkService;

    public List<ObjDto> getAll() {
        List<ObjDo> objList = objRepo.getAll();
        return objList.stream()
                .map(this::mapTo)
                .filter(Objects::nonNull)
                .toList();
    }

    public ObjDto getById(Long id) {
        ObjDo objDo = objRepo.getById(id);
        return objDo != null ? mapTo(objDo) : null;
    }

    protected ObjDto mapTo(ObjDo objDo) {
        ObjDto result = objDoToObjDtoMapper.mapTo(objDo);
        List<ObjDto> fieldList = fieldLinkService.getAll(objDo.getId()).stream()
                .map(fieldLinkDo -> getById(fieldLinkDo.getObjId()))
                .filter(Objects::nonNull)
                .toList();
        result.setFields(fieldList);

        result.setGroups(groupLinkService.getAll(objDo.getId()));
        return result;
    }
}
