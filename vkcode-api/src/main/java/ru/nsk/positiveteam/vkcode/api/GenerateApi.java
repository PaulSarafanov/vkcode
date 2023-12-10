package ru.nsk.positiveteam.vkcode.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1")
public interface GenerateApi {

    @GetMapping("/generate/program/string/{programId}")
    String generateProgramStr(@PathVariable Long programId);

    @GetMapping("/generate/program/{programId}")
    String generateProgram(@PathVariable Long programId);
}
