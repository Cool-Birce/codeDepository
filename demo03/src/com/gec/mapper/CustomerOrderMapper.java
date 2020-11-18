package com.gec.mapper;

import com.gec.pojo.CustomerOrder;

import java.util.List;

/**
 * @author Brice
 * @title: CustomerOrderMapper
 * @projectName demo03
 * @description: TODO
 * @date 2020/11/219:08
 */
public interface CustomerOrderMapper {
    List<CustomerOrder> findAll();
    List<CustomerOrder> oneBymore(int id);
}
