package edu.hue.jk.mapper;


import edu.hue.jk.model.OrderItemVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    @Select("select * from orderitem where order_id = #{orderId}")
    @Results({
            @Result(column = "order_id",property = "orderId"),
            @Result(column = "product_id",property = "productId"),
            @Result(column = "product_id",property = "products",
                    one = @One(select = "edu.hue.jk.mapper.ProductsMapper.selectById")
            )

    })
    public List<OrderItemVO> selectByOrderId(String orderId);
}
