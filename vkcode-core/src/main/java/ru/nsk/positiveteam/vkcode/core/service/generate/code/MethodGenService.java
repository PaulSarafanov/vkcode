package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.MethodSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjMethodLinkDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjDataService;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjMethodDataService;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class MethodGenService {
    private final ObjMethodDataService objMethodDataService;
    private final ObjDataService objDataService;
    private final PackageNameService packageNameService;

    public List<MethodSpec> generate(ProgramDto programDto, ObjDto mainObjDto) {
        return objMethodDataService.getByMainObjId(mainObjDto.getId()).stream()
                .map(elem -> generate(programDto, elem))
                .toList();
    }

    protected MethodSpec generate(ProgramDto programDto, ObjMethodLinkDto linkDto) {
        MethodDto methodDto = objMethodDataService.getByObjMethodLinkDto(linkDto);
        return generate(programDto, linkDto, methodDto);
    }

    protected MethodSpec generate(ProgramDto programDto, ObjMethodLinkDto linkDto, MethodDto methodDto) {
        return MethodSpec.methodBuilder(methodDto.getName())
                .addModifiers(getModifiers(linkDto))
                .returns(getReturnType(programDto, methodDto))
                .build();
    }

    protected Type getReturnType(ProgramDto programDto, MethodDto methodDto) {
        ObjDto objDto = objDataService.getById(methodDto.getReturnObjId());
        return packageNameService.getClass(programDto, objDto);
    }

    protected List<Modifier> getModifiers(ObjMethodLinkDto linkDto) {
        //todo переделать на abstrac,public и case
        List<Modifier> result = new ArrayList<>();
        if ("public".equals(linkDto.getType())) {
            result.add(Modifier.PUBLIC);
        }

        if ("abstractPublic".equals(linkDto.getType())) {
            result.add(Modifier.PUBLIC);
            result.add(Modifier.ABSTRACT);
        }
        return result;
    }
}
