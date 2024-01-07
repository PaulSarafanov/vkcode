package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ProgramDependenciesLinkDo;

import java.util.List;

public interface ProgramDependenciesLinkRepo {
    @Select("SELECT * FROM program_dependencies_link_table WHERE program_id = #{programId}")
    @Results({
            @Result(property = "programId", column = "program_id"),
            @Result(property = "dependencyProgramId", column = "dependency_program_id")
    })
    List<ProgramDependenciesLinkDo> getByProgramId(Long programId);
}
