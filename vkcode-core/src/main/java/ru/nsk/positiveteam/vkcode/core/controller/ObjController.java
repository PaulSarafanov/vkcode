package ru.nsk.positiveteam.vkcode.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.ObjApi;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.service.data.FieldLinkService;
import ru.nsk.positiveteam.vkcode.core.service.data.GroupLinkService;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ObjController implements ObjApi {
    private final ObjService objService;
    private final FieldLinkService fieldLinkService;
    private final GroupLinkService groupLinkService;

    public List<ObjDto> getAllObj() {
        return objService.getAll();
    }

    @Override
    public ObjDto getObjById(Long objId) {
        ObjDto result = objService.getById(objId);
        result.setFields(fieldLinkService.getAll(objId));
        result.setGroups(groupLinkService.getAll(objId));
        return result;
    }
}
