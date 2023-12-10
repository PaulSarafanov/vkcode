package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.GroupDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.*;
import static ru.nsk.positiveteam.vkcode.core.service.code.AnnotationGenService.*;
import static ru.nsk.positiveteam.vkcode.core.service.code.TypeSpecGenService.*;

@Service
@AllArgsConstructor
public class GroupService {
    //todo продумать как получать по объекту его доп пакет

    public String getAddPackage(List<GroupDto> groupDtoList) {
        return getAdd("API", "api", groupDtoList);
    }

    public String getClassType(List<GroupDto> groupDtoList) {
        String result = getAdd(INTERFACE_CLASS, INTERFACE_CLASS, groupDtoList);
        if (hasText(result)) {
            return result;
        }
        return "";
    }

    public List<String> getAnnotations(List<GroupDto> groupDtoList) {
        String result = getAdd(FUNCTIOANL_INTERFACE, FUNCTIOANL_INTERFACE_RESULT, groupDtoList);
        if (hasText(result)) {
            return List.of(result);
        }
        return Collections.emptyList();
    }

    protected String getAdd(String groupName, String returnStr, List<GroupDto> groupDtoList) {
        Optional<GroupDto> optional = groupDtoList.stream()
                .filter(dto -> groupName.equals(dto.getName()))
                .findFirst();
        if (optional.isPresent()) {
            return returnStr;
        }
        return "";
    }
}
