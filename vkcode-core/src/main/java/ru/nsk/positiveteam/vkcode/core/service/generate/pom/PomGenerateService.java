package ru.nsk.positiveteam.vkcode.core.service.generate.pom;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class PomGenerateService {

    public void generate(Path path, ProgramDto dto) {
        Path pomPath = path.resolve("pom.xml");
        try {
            Files.write(pomPath, getPomStr(dto).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getPomStr(ProgramDto dto) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "\n" +
                "    <parent>\n" +
                STR. "        <groupId>\{ dto.getGroupId() }</groupId>\n" +
                STR. "        <artifactId>\{ dto.getName().toLowerCase() }</artifactId>\n" +
                STR. "        <version>\{ dto.getVersion() }</version>\n" +
                "    </parent>\n" +
                "\n" +
                STR. "    <artifactId>\{ dto.getName().toLowerCase() }-generated</artifactId>\n" +
                "    <packaging>jar</packaging>\n" +
                "\n" +
                getDependencies() +
                "</project>";
    }

    private String getDependencies() {
        //todo
        return "";
    }
}
