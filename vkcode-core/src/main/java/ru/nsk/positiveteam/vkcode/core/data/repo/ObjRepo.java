package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.generated.v1.data.ObjDo;

public interface ObjRepo {
    @Select("SELECT * FROM obj_table WHERE id = #{id}")
    @Results({
            @Result(property = "packageName", column = "package_name"),
            @Result(property = "addPackageName", column = "add_package_name")
    })
    ObjDo getById(Long id);
}
