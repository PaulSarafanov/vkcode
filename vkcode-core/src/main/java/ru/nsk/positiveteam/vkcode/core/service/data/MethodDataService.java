package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.core.data.mapper.MethodDoToMethodDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.MethodRepo;
import ru.nsk.positiveteam.vkcode.generated.v1.data.MethodDo;

@Service
@AllArgsConstructor
public class MethodDataService {
    private final MethodRepo methodRepo;
    private final MethodDoToMethodDtoMapper methodDoToMethodDtoMapper;

    public MethodDto getById(Long id) {
        MethodDo methodDo = methodRepo.getById(id);
        return methodDo != null ? methodDoToMethodDtoMapper.mapTo(methodDo) : null;
    }
}
