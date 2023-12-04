package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.GroupDto;
import ru.nsk.positiveteam.vkcode.core.data.GroupLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.GroupDoToGroupDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.GroupLinkRepo;
import ru.nsk.positiveteam.vkcode.core.data.repo.GroupRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupLinkService {
    private GroupRepo groupRepo;
    private GroupLinkRepo groupLinkRepo;
    private GroupDoToGroupDtoMapper groupDoToGroupDtoMapper;

    public List<GroupDto> getAll(Long objId) {
        List<GroupLinkDo> objList = groupLinkRepo.getByObjId(objId);
        return objList.stream()
                .map(elem -> groupRepo.getById(elem.getGroupId()))
                .map(groupDoToGroupDtoMapper::mapTo)
                .collect(Collectors.toList());
    }
}
