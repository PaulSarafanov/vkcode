package ru.nsk.positiveteam.vkcode.core.service.code;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;

@Service
@AllArgsConstructor
public class ObjCodeGenService {
    private final PackgeCodeGenService packgeCodeGenService;
    private final ImportCodeGenService importCodeGenService;
    private final AnnotationCodeGenService annotationCodeGenService;
    private final ClassNameCodeGenService classNameCodeGenService;
    private final ExtendsCodeGenService extendsCodeGenService;
    private final ImplementsCodeGenService implementsCodeGenService;
    private final BodyCodeGenService bodyCodeGenService;

    public String generate(ProgramDto programDto, ObjDto dto) {
        String result = packgeCodeGenService.generateCode(dto) +
                "\n\n" +
                importCodeGenService.generate(dto) +
                "\n\n" +
                annotationCodeGenService.generate(dto) +
                "\n" +
                classNameCodeGenService.generate(dto) +
                extendsCodeGenService.generate(dto) +
                implementsCodeGenService.generate(dto) +
                bodyCodeGenService.generate(dto);
        return result;
    }

}
