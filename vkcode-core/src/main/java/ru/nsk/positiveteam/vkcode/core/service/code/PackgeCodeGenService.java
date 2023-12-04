package ru.nsk.positiveteam.vkcode.core.service.code;

import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;

@Service
public class PackgeCodeGenService {
    public String generateCode(ObjDto dto) {
        return "package ru.nsk.positiveteam.vkcode.test;";
    }
}
