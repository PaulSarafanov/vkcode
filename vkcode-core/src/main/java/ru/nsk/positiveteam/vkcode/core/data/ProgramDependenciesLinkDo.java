package ru.nsk.positiveteam.vkcode.core.data;

import lombok.Data;

@Data
public class ProgramDependenciesLinkDo {
    private Long id;
    private Long programId;
    private Long dependencyProgramId;
}
