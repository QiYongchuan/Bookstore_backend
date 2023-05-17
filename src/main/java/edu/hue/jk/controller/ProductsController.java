package edu.hue.jk.controller;

import edu.hue.jk.mapper.ProductsMapper;
import edu.hue.jk.model.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsMapper productsMapper;

    @Value("${bookstore.url-locations}")
    private String urlPath;

    @Value("${bookstore.upload-locations}")
    private String uploadLocations;
    @RequestMapping("list")
    public String list(Model model, String id,String category,String name,Double lowPrice,Double highPrice){
        List<products> productsList = productsMapper.selectAll(id,category,name,lowPrice,highPrice);
        model.addAttribute(productsList);

        return "products/list";
    }
    @RequestMapping("del")
    public String del(Model model,String id){
        productsMapper.del(id);
        List<products> productsList = productsMapper.selectAll(null,null,null,null,null);
        model.addAttribute(productsList);

        return "products/list";
    }
    @RequestMapping("add")
    public String add(){
        return "products/add";
    }
    @RequestMapping("save")
    private String save(Model model, products products, MultipartFile img){
        products.setId(UUID.randomUUID().toString()); //生成新的id号

        String imgFileName = products.getId() + ".jpg";
        products.setImgurl(urlPath + "/" + imgFileName);  //存到数据库里面的部分

        productsMapper.insert(products); //插入数据库

        //文件传输
        try {
            img.transferTo(new File(uploadLocations + "/" + imgFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<products> productsList = productsMapper.selectAll(null,null,null,null,null);
        model.addAttribute(productsList);

        return "products/list";
    }
}
