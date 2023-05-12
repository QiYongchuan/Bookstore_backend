package edu.hue.jk.mapper;

import edu.hue.jk.model.products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductsMapper {
//    当属性与数据库中字段不一样时
    @Select("select *  from products ")
    public List<products> selectAll();

    @Select("select * from products where id = #{id}")
    public void selectById(Integer id);

    @Insert("insert into products(id,name,price,category,pnum,imgurl,description) values(#{id},#{name},#{price},#{category},#{pnum},#{imgurl},#{description})")
    public void insert(products products);

    @Update("update products set id=#{id},name=#{name},price=#{price},category=#{category},pnum=#{pnum},imgurl=#{imgurl},description=#{description} where id = #{id}")
    public void update(products products);

    @Delete("delete from products where id=#{id}")
    public void del(String id);
}
