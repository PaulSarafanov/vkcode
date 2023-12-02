package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;

@Service
@AllArgsConstructor
public class PackageNameService {

    public String getPackageName(ProgramDto programDto, ObjDto objDto) {
       if ("Inner".equals(objDto.getType()) || "Class".equals(objDto.getType())) {
            return programDto.getGroupId() + ".generated";
        } else {
            return programDto.getGroupId() + ".generated."+objDto.getType().toLowerCase();
        }
    }
}
