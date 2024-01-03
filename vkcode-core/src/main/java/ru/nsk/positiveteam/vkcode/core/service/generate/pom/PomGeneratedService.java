package ru.nsk.positiveteam.vkcode.core.service.generate.pom;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsk.positiveteam.vkcode.api.dto.ProgramDto;
import ru.nsk.positiveteam.vkcode.core.service.data.ProgramDependenciesDataService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Service
@AllArgsConstructor
public class PomGeneratedService {
    private final ProgramDependenciesDataService programDependenciesDataService;

    public void generate(Path path, ProgramDto dto) {
        Path pomPath = path.resolve("pom.xml");
        try {
            Files.createDirectories(path);
            Files.write(pomPath, getPomStr(dto).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
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
                "        <groupId>" + dto.getGroupId() + "</groupId>\n" +
                "        <artifactId>" + dto.getName().toLowerCase() + "</artifactId>\n" +
                "        <version>" + dto.getVersion() + "</version>\n" +
                "    </parent>\n" +
                "\n" +
                "    <artifactId>" + dto.getName().toLowerCase() + "-generated</artifactId>\n" +
                "    <packaging>jar</packaging>\n" +
                "\n" +
                getDependencies(dto) +
                "</project>";
    }

    private String getDependencies(ProgramDto dto) {
        List<ProgramDto> dependencies = programDependenciesDataService.getObjDtoByProgramId(dto.getId());
        if (dependencies.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder("    <dependencies>\n");
        dependencies.stream()
                .filter(elem -> hasText(elem.getGroupId()))
                .forEach(elem -> result.append("        <dependency>\n")
                        .append("            <groupId>")
                        .append(elem.getGroupId())
                        .append("</groupId>\n")
                        .append("            <artifactId>")
                        .append(elem.getName())
                        .append("</artifactId>\n")
                        .append("            <version>")
                        .append(elem.getVersion())
                        .append("</version>\n")
                        .append("        </dependency>\n"));
        result.append("    </dependencies>\n");
        return result.toString();
    }
}
