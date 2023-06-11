package edu.hue.jk.mapper;


import edu.hue.jk.model.Order;
import edu.hue.jk.model.OrdersVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from orders")
    @Results({
            @Result(column = "user_id",
                    property = "user",
                    one = @One(select = "edu.hue.jk.mapper.UseMapper.selectById")
            ),
            @Result(column = "user_id",
                    property = "userId"
            ),
            @Result(column = "id",
                   property = "items",
                   many = @Many(select = "edu.hue.jk.mapper.OrderItemMapper.selectByOrderId")
            ),
//            @Result(column = "id",
//                    property = ""
//            )

    })
    List<OrdersVO> selectAll();
}
