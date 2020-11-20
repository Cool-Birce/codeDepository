package com.gec.service;

import com.gec.pojo.Product;

import java.util.List;

/**
 * @author Brice
 * @title: ProductService
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1020:21
 */
public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    int update(Product product);
    int del(Integer id);
    List<Product> selectCondition(Product product);
}
