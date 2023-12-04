package ru.nsk.positiveteam.vkcode.core.service.code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import ru.nsk.positiveteam.vkcode.BaseSpringTest;
import ru.nsk.positiveteam.vkcode.api.dto.ObjDto;

import static org.junit.jupiter.api.Assertions.*;

public class NameObjCodeGenTest extends BaseSpringTest {
    @Autowired
    private ObjCodeGenService service;
    @Value("classpath:../test-classes/java/example/name_obj.json")
    private Resource defResource;
    @Value("classpath:../test-classes/java/example/name_obj.result")
    private Resource resultResource;

    @Test
    public void testObjDoGeneration() {
        ObjDto defDto = toDto(defResource, ObjDto.class);
        var result = service.generate(defDto);
        assertEquals(toString(resultResource), result);
    }

}