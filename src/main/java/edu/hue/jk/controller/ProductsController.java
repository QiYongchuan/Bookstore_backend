package edu.hue.jk.controller;

import edu.hue.jk.mapper.ProductsMapper;
import edu.hue.jk.model.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsMapper productsMapper;

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
}
