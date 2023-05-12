package edu.hue.jk;


import edu.hue.jk.mapper.NoticeMapper;
import edu.hue.jk.mapper.ProductsMapper;
import edu.hue.jk.model.products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductsMapperTest {
    @Autowired
    private ProductsMapper ProductsMapper;

    @Test
    public void test1(){
        List<products> productsList = ProductsMapper.selectAll();
        System.out.println(productsList);

        products products = new products();
        products.setId("000001");
        products.setCategory("科技类");
        products.setName("30天入门系列");
        products.setPnum(10);
        products.setImgurl("www.baidu.com/image");

        products.setName("0基础，学IT，月薪过万");
        ProductsMapper.update(products);

        products.setId("0000002");
        ProductsMapper.insert(products);

        products.setName("test");
        ProductsMapper.update(products);

        ProductsMapper.del("0000002");
    }
    public void test2(){
        List<products> productsList = ProductsMapper.selectAll();
        System.out.println(productsList);

    }
}
