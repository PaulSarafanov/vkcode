package ru.nsk.positiveteam.vkcode.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.ObjApi;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ObjController implements ObjApi {
    private final ObjService objService;

    public List<ObjDto> getAllObj() {
        return objService.getAll();
    }

    @Override
    public ObjDto getObjById(Long objId) {
        ObjDto result = objService.getById(objId);
        return result;
    }
}
