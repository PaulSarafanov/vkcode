package ru.nsk.positiveteam.vkcode.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;

import java.util.List;

@RequestMapping("/v1")
public interface ObjApi {
    @GetMapping("/obj")
    List<ObjDto> getAllObj();
}
