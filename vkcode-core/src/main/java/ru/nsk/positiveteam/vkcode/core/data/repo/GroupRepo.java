package ru.nsk.positiveteam.vkcode.core.data.repo;

import org.apache.ibatis.annotations.Select;
import ru.nsk.positiveteam.vkcode.core.data.GroupDo;

public interface GroupRepo {
    @Select("SELECT * FROM group_table WHERE id = #{id}")
    GroupDo getById(Long id);
}
