package ru.nsk.positiveteam.vkcode.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.ObjApi;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjDataService;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;

@RestController
@AllArgsConstructor
public class ObjController implements ObjApi {
    private final ObjDataService objDataService;

    @Override
    public ObjDto getObjById(Long objId) {
        return objDataService.getById(objId);
    }
}
