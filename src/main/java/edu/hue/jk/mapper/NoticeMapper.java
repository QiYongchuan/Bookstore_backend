package edu.hue.jk.mapper;

import edu.hue.jk.model.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {
//    当属性与数据库中字段不一样时
    @Select("select n_id nId,title,details,n_time nTime  from notice ")
    public List<Notice> selectAll();

    @Select("select * from notice where n_id = #{nId}")
    public Notice selectById(Integer nId);

    @Insert("insert into notice(n_id,title,details,n_time) values(#{nId},#{title},#{details},#{nTime})")
    public void insert(Notice notice);

    @Update("update notice set n_times=#{nTime},title=#{title},details=#{details} where n_id = #{nId}")
    public void update(Notice notice);

    @Delete("delete from notice where n_id=#{nId}")
    public void del(Integer nId);
}
