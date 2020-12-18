package com.eshop.order.service;

import com.eshop.order.pojo.OrderItem;

import java.util.List;

public interface CartService {
    /***
     * 加入购物车
     */

    void add(Integer num, Long id, String username);

    /***
     * 购物车集合查询
     */
    List<OrderItem> list(String username);
}
