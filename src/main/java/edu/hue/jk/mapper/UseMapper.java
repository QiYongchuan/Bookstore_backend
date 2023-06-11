package edu.hue.jk.mapper;

import edu.hue.jk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UseMapper {
    @Select("select * from user where id =#{id}")
    public User selectById(Integer id);
}
