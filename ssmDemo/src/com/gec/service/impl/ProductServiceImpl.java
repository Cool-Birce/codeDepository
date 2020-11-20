package com.gec.service.impl;

import com.gec.dao.ProductMapper;
import com.gec.pojo.Product;
import com.gec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Brice
 * @title: ProductServiceImpl
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1020:22
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll() {
        return productMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int del(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Product> selectCondition(Product product) {
        return productMapper.selectCondition(product);

    }
}
