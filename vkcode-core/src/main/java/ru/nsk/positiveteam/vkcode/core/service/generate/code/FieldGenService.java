package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.FieldSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjFieldLinkDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjFieldDataService;

import javax.lang.model.element.Modifier;
import java.util.List;


@Service
@AllArgsConstructor
public class FieldGenService {
    private final ObjFieldDataService objFieldDataService;
    private final PackageNameService packageNameService;

    public List<FieldSpec> generate(ProgramDto programDto, ObjDto mainObjDto) {
        return objFieldDataService.getByObjId(mainObjDto.getId()).stream()
                .map(elem -> generate(programDto, elem))
                .toList();
    }

    protected FieldSpec generate(ProgramDto programDto, ObjFieldLinkDto linkDto) {
        ObjDto objDto = objFieldDataService.getByObjFieldLinkDto(linkDto);
        return generate(programDto, linkDto, objDto);
    }

    protected FieldSpec generate(ProgramDto programDto, ObjFieldLinkDto linkDto, ObjDto objDto) {
        FieldSpec.Builder result = FieldSpec.builder(packageNameService.getClass(programDto, objDto), linkDto.getName());
        addModifiers(result, linkDto);
        return result.build();
    }

    protected void addModifiers(FieldSpec.Builder result, ObjFieldLinkDto linkDto) {
        //todo переделать на abstrac,private и case
        if ("public".equals(linkDto.getType())) {
            result.addModifiers(Modifier.PUBLIC);
        }
        if ("private".equals(linkDto.getType())) {
            result.addModifiers(Modifier.PRIVATE);
        }
    }
}
