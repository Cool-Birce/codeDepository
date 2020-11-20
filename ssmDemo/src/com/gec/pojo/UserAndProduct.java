package com.gec.pojo;

import java.util.List;

/**
 * @author Brice
 * @title: UserAndProduct
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1118:55
 */
public class UserAndProduct {
    private User user;
    private Product product;
    private List<Product> productList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
