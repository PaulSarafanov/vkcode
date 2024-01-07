package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.generated.v1.data.MethodDo;

public interface MethodRepo {
    @Select("SELECT * FROM method_table WHERE id = #{id}")
    @Results({
            @Result(property = "returnObjId", column = "return_obj_id")
    })
    MethodDo getById(Long id);
}
