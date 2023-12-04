package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.ObjDo;

import java.util.List;

public interface ObjRepo {
    @Select("SELECT * FROM obj_table")
    List<ObjDo> getAll();

    @Select("SELECT * FROM obj_table WHERE id = #{id}")
    ObjDo getById(Long id);
}
