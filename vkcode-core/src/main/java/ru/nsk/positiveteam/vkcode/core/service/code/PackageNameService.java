package ru.nsk.positiveteam.vkcode.core.service.code;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.GroupService;

@Service
@AllArgsConstructor
public class PackageNameService {
    private final GroupService groupService;

    public String getPackageName(ProgramDto dto, ObjDto objDto) {
        return dto.getGroupId() + ".generated." + groupService.getAddPackage(objDto.getGroups());
    }

    public String getPackageStr(ProgramDto dto, ObjDto objDto) {
        return STR. "package \{ this.getPackageName(dto, objDto) };" ;
    }
}
