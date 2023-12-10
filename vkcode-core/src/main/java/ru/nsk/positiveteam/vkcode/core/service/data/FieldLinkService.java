package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.core.data.FieldLinkDo;
import ru.nsk.positiveteam.vkcode.core.data.repo.FieldLinkRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class FieldLinkService {
    private FieldLinkRepo fieldLinkRepo;

    public List<FieldLinkDo> getAll(Long mainObjId) {
        return fieldLinkRepo.getByMainObjId(mainObjId);
    }
}
