package edu.hue.jk.mapper;

import edu.hue.jk.model.Products;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface ProductsMapper {

    class Provider{
        public String filter(
                @Param("id") String id,
                @Param("category") String category,
                @Param("name") String name,
                @Param("lowPrice") Double lowPrice,
                @Param("highPrice") Double highPrice) {
            SQL sql = new SQL();
            sql.SELECT("* from products");
            if (id != null && id.trim().length()>0){
                sql.WHERE("id = #{id}");
            }
            if (category != null && category.trim().length()>0){
                sql.WHERE("category = #{category}");
            }
            if (name != null && name.trim().length()>0){
                sql.WHERE("name like concat('%', #{name} ,'%')");
            }
            if (lowPrice != null){
                sql.WHERE("price >= #{lowPrice}");
            }
            if (highPrice != null){
                sql.WHERE("price <=#{highPrice}");
            }
            return sql.toString();
        }
    }

//    @Select("select *  from products ")
    @SelectProvider(type = Provider.class,method = "filter")
    public List<Products> selectAll(
            @Param("id") String id,
            @Param("category") String category,
            @Param("name") String name,
            @Param("lowPrice") Double lowPrice,
            @Param("highPrice") Double highPrice
    );

    @Select("select * from products where id = #{id}")
    public Products selectById(String id);

    @Insert("insert into products(id,name,price,category,pnum,imgurl,description) values(#{id},#{name},#{price},#{category},#{pnum},#{imgurl},#{description})")
    public void insert(Products products);

    @Update("update products set id=#{id},name=#{name},price=#{price},category=#{category},pnum=#{pnum},imgurl=#{imgurl},description=#{description} where id = #{id}")
    public void update(Products products);

    @Delete("delete from products where id=#{id}")
    public void del(String id);

    @Delete("delete from products where price <= #{highPrice} and price >= #{lowPrice}")
        public void del2(@Param("highPrice") Double highPrice, @Param("lowPrice") Double lowPrice);

}
