package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.FieldLinkDo;

import java.util.List;

public interface FieldLinkRepo {
    @Select("SELECT * FROM field_link_table WHERE main_obj_id = #{mainObjId}")
    @Results({
            @Result(property = "mainObjId", column = "main_obj_id"),
            @Result(property = "objId", column = "obj_id")
    })
    List<FieldLinkDo> getByMainObjId(Long mainObjId);
}