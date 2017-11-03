package com.kaishengit.service;

import com.kaishengit.entity.Product;

import java.util.List;

/**
 * Created by hoyt on 2017/11/3.
 */

public interface ProductService {
    Product findById(Integer id);
    void save(Product product);
    List<Product> findByPageNo(Integer pageNo);
}
