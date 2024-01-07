package ru.nsk.positiveteam.vkcode.core.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ParameterDto;
import ru.nsk.positiveteam.vkcode.core.data.ParameterDo;
import ru.nsk.positiveteam.vkcode.core.data.mapper.ParameterDoToParameterDtoMapper;
import ru.nsk.positiveteam.vkcode.core.data.repo.ParameterRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ParameterService {
    private ParameterRepo repo;
    private ParameterDoToParameterDtoMapper mapper;

    public List<ParameterDto> getByMethodId(Long methodId) {
        List<ParameterDo> list = repo.getByMethodId(methodId);
        return mapper.mapTo(list);
    }
}
