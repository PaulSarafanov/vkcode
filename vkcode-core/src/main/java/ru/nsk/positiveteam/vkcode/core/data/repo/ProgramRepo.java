package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ProgramDo;

public interface ProgramRepo {
    @Select("SELECT * FROM program_table WHERE id = #{id}")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    ProgramDo getById(Long id);
}
