package edu.hue.jk;


import edu.hue.jk.mapper.OrderMapper;
import edu.hue.jk.model.Order;
import edu.hue.jk.model.OrdersVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTest {
    @Autowired
    private OrderMapper OrderMapper;

    @Test
    public void test1(){
        List<OrdersVO> OrderList = OrderMapper.selectAll();
        System.out.println(OrderList);
    }

}
