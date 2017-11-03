package com.kaishengit.service.impl;

import com.kaishengit.entity.Product;
import com.kaishengit.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by hoyt on 2017/11/3.
 */
public class ProductServiceImplTest extends BaseTest{

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findById() throws Exception {
        Product product = new Product();
        product = productService.findById(1);
        System.out.println(product);
    }

    @Test
    public void save() throws Exception {
        Product product = new Product();
        product.setProductName("奥迪A8");
        product.setProductInventory(180);
        productService.save(product);
    }

}