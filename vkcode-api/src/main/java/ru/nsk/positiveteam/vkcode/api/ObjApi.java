package ru.nsk.positiveteam.vkcode.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;

@RequestMapping("/v1")
public interface ObjApi {
    @GetMapping("/obj/{objId}")
    ObjDto getObjById(@PathVariable Long objId);
}
