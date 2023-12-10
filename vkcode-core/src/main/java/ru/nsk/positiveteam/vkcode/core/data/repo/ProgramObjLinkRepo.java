package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.ProgramObjLinkDo;

import java.util.List;

public interface ProgramObjLinkRepo {
    @Select("SELECT * FROM program_obj_link_table WHERE program_id = #{programId}")
    @Results({
            @Result(property = "programId", column = "program_id"),
            @Result(property = "objId", column = "obj_id")
    })
    List<ProgramObjLinkDo> getByProgramId(Long programId);
}
