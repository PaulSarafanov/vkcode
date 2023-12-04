package ru.nsk.positiveteam.vkcode.core.service.code;

import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;

@Service
public class ImplementsCodeGenService {
    public String generate(ObjDto dto) {
        return " implements ";
    }
}
