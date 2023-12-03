package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ObjDoToObjDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ObjService {
    private ObjRepo objRepo;
    private ObjDoToObjDtoMapper objDoToObjDtoMapper;

    public List<ObjDto> getAll() {
        List<ObjDo> objList = objRepo.getAll();
        return objDoToObjDtoMapper.mapTo(objList);
    }
}
