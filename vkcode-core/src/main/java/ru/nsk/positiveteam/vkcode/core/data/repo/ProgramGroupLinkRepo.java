package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.ProgramGroupLinkDo;

import java.util.List;

public interface ProgramGroupLinkRepo {
    @Select("SELECT * FROM program_group_link_table WHERE program_id = #{programId}")
    @Results({
            @Result(property = "programId", column = "program_id"),
            @Result(property = "groupId", column = "group_id")
    })
    List<ProgramGroupLinkDo> getByProgramId(Long programId);
}
