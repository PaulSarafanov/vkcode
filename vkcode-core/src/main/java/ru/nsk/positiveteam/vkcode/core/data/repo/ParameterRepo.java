package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.ParameterDo;

import java.util.List;

public interface ParameterRepo {
    @Select("SELECT * FROM parameter_table WHERE method_id = #{methodId}")
    @Results({
            @Result(property = "methodId", column = "method_id"),
            @Result(property = "objId", column = "obj_id")
    })
    List<ParameterDo> getByMethodId(Long methodId);
}
