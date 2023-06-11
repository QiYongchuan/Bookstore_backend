package edu.hue.jk;


import edu.hue.jk.mapper.ProductsMapper;
import edu.hue.jk.model.Products;
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
        List<Products> productsList = ProductsMapper.selectAll(null,null,null,null
        ,null);
        System.out.println(productsList);

        Products products = new Products();
        products.setId("000001");
        products.setCategory("科技类");
        products.setName("30天入门系列");
        products.setPnum(10);
        products.setImgurl("www.baidu.com/image");
        products.setPrice(100.00);
        products.setName("0基础，学IT，月薪过万");
        ProductsMapper.update(products);

        products.setId("0000002");
        ProductsMapper.insert(products);

        products.setName("test");
        ProductsMapper.update(products);

        ProductsMapper.del("0000002");

        //新增几个价格在10到5之间的

    }
    @Test
    public void test2(){
        ProductsMapper.del2(10.0,5.0);
    }

    @Test
    public void test3(){
        System.out.println(ProductsMapper.selectAll("000001", null, null, null, null));
        System.out.println(ProductsMapper.selectAll("null", "计算机", null, null, null));
        System.out.println(ProductsMapper.selectAll("000001", "计算机", null, 100d, null));
        System.out.println(ProductsMapper.selectAll("000001", null, null, null, 500d));
        System.out.println(ProductsMapper.selectAll("000001", null, null, 300d, 500d));
    }
}
