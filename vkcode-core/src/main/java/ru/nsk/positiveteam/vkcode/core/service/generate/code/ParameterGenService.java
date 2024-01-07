package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.ParameterSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.api.dto.ParameterDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjDataService;
import ru.nsk.positiveteam.vkcode.core.service.data.ParameterService;
import ru.nsk.positiveteam.vkcode.generated.v1.api.dto.ObjDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParameterGenService {
    private final ParameterService parameterService;
    private final ObjDataService objDataService;
    private final PackageNameService packageNameService;

    public List<ParameterSpec> getParameters(ProgramDto programDto, MethodDto methodDto) {
        return parameterService.getByMethodId(methodDto.getId()).stream()
                .sorted(Comparator.comparing(ParameterDto::getNum))
                .map(elem -> getOne(programDto, elem))
                .collect(Collectors.toList());
    }

    protected ParameterSpec getOne(ProgramDto programDto, ParameterDto parameterDto) {
        ObjDto objDto = objDataService.getById(parameterDto.getObjId());
        return ParameterSpec.builder(packageNameService.getClassName(programDto, objDto), parameterDto.getName())
                .build();
    }
}
