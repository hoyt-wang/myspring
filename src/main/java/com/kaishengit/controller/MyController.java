package com.kaishengit.controller;

import com.kaishengit.entity.Product;
import com.kaishengit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hoyt on 2017/11/3.
 */

@Controller
public class MyController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    @ResponseBody
    public List<Product> page(@RequestParam(name = "p") Integer pageNo) {
        return productService.findByPageNo(pageNo);
    }

    @GetMapping("/product/{id:\\d+}")
    @ResponseBody
    public Product findById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        return product;

    }
}
