package ru.nsk.positiveteam.vkcode.core.service.generate.code;

import lombok.AllArgsConstructor;
import org.springframework.javapoet.MethodSpec;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.MethodDto;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjDataService;
import ru.nsk.positiveteam.vkcode.core.service.data.ObjMethodDataService;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.List;


@Service
@AllArgsConstructor
public class MethodGenService {
    private final ObjMethodDataService objMethodDataService;
    private final ObjDataService objDataService;

    public List<MethodSpec> generate(ObjDto objDto) {
        return objMethodDataService.getByObjId(objDto.getId()).stream()
                .map(methodDto -> generate(methodDto, objDto))
                .toList();
    }

    protected MethodSpec generate(MethodDto methodDto, ObjDto objDto) {
        return MethodSpec.methodBuilder(methodDto.getName())
                .returns(getReturnType(methodDto))
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .build();
    }

    protected Type getReturnType(MethodDto methodDto) {
        ObjDto objDto = objDataService.getById(methodDto.getReturnObjId());
        //todo доделать определение имени класса
        String className = objDto.getClassName();
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
