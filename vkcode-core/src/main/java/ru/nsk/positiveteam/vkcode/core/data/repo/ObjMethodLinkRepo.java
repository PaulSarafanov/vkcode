package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.ObjMethodLinkDo;

import java.util.List;

public interface ObjMethodLinkRepo {
    @Select("SELECT * FROM obj_method_link_table WHERE obj_id = #{objId}")
    @Results({
            @Result(property = "methodId", column = "method_id"),
            @Result(property = "objId", column = "obj_id")
    })
    List<ObjMethodLinkDo> getByObjId(Long objId);
}
