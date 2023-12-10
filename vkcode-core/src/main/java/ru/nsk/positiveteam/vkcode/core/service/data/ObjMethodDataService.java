package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.core.data.ObjMethodLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.repo.ObjMethodLinkRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ObjMethodDataService {
    private final ObjMethodLinkRepo objMethodLinkRepo;
    private final MethodDataService methodDataService;

    public List<MethodDto> getByObjId(Long objId) {
        List<ObjMethodLinkDo> methodDo = objMethodLinkRepo.getByObjId(objId);
        return methodDo.stream()
                .map(ObjMethodLinkDo::getMethodId)
                .map(methodDataService::getById)
                .toList();
    }
}
