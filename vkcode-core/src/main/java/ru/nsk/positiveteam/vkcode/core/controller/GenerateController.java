package ru.nsk.positiveteam.vkcode.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.GenerateApi;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.service.code.ObjCodeGenService;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjService;

@RestController
@AllArgsConstructor
public class GenerateController implements GenerateApi {
    private ObjService objService;
    private ObjCodeGenService service;

    @Override
    public String generateStr(Long objId) {
        ObjDto objDto = objService.getById(objId);
        return objDto != null ? service.generate(objDto) : "Not Found";
    }
}
