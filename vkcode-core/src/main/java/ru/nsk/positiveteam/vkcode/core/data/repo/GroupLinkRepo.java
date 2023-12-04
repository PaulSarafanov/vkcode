package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.GroupLinkDo;

import java.util.List;

public interface GroupLinkRepo {
    @Select("SELECT * FROM group_link_table WHERE obj_id = #{objId}")
    @Results({
            @Result(property = "objId", column = "obj_id"),
            @Result(property = "groupId", column = "group_id")
    })
    List<GroupLinkDo> getByObjId(Long objId);
}
