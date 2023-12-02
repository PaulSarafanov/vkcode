package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.FieldSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjFieldLinkDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjFieldDataService;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.List;


@Service
@AllArgsConstructor
public class FieldGenService {
    private final ObjFieldDataService objFieldDataService;

    public List<FieldSpec> generate(ObjDto mainObjDto) {
        return objFieldDataService.getByObjId(mainObjDto.getId()).stream()
                .map(this::generate)
                .toList();
    }

    protected FieldSpec generate(ObjFieldLinkDto linkDto) {
        ObjDto objDto = objFieldDataService.getByObjFieldLinkDto(linkDto);
        return generate(linkDto, objDto);
    }

    protected FieldSpec generate(ObjFieldLinkDto linkDto, ObjDto objDto) {
        FieldSpec.Builder result = FieldSpec.builder(getFieldType(objDto), linkDto.getName());
        addModifiers(result, linkDto);
        return result.build();
    }

    protected Type getFieldType(ObjDto objDto) {
        //todo доделать определение имени класса
        String className = objDto.getClassName();
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
