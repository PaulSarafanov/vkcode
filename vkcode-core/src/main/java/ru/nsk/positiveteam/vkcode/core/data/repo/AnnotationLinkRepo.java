package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.generated.v1.data.AnnotationLinkDo;

import java.util.List;

public interface AnnotationLinkRepo {
    @Select("SELECT * FROM annotation_link_table WHERE main_obj_id = #{mainObjId}")
    @Results({
            @Result(property = "mainObjId", column = "main_obj_id"),
            @Result(property = "objId", column = "obj_id")
    })
    List<AnnotationLinkDo> getByMainObjId(Long mainObjId);
}
