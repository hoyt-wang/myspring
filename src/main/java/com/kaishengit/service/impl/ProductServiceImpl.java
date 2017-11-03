package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductExample;
import com.kaishengit.mapper.ProductMapper;
import com.kaishengit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hoyt on 2017/11/3.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Product product) {
        productMapper.insert(product);
    }

    @Override
    public List<Product> findByPageNo(Integer pageNo) {
        PageHelper.startPage(pageNo,4);
        ProductExample productExample = new ProductExample();
        return productMapper.selectByExample(productExample);
    }
}
