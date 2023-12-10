package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.ObjDo;

public interface ObjRepo {
    @Select("SELECT * FROM obj_table WHERE id = #{id}")
    @Results({
            @Result(property = "className", column = "class_name")
    })
    ObjDo getById(Long id);
}
