package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ObjDoToObjDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjRepo;

@Service
@AllArgsConstructor
public class ObjDataService {
    private ObjRepo objRepo;
    private ObjDoToObjDtoMapper objDoToObjDtoMapper;

    public ObjDto getById(Long id) {
        ObjDo objDo = objRepo.getById(id);
        return objDo != null ? objDoToObjDtoMapper.mapTo(objDo) : null;
    }
}
