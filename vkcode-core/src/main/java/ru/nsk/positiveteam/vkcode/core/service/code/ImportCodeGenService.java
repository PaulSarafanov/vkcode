package ru.nsk.positiveteam.vkcode.core.service.code;

import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;

@Service
public class ImportCodeGenService {
    public String generate(ObjDto dto) {
        StringBuilder builder = new StringBuilder();
        dto.getFields().forEach(elem -> builder.append("import ").append(elem.getClassName()).append(";\n"));
        return builder.toString();
    }
}
