package com.eshop.order.controller;

import com.eshop.order.pojo.OrderItem;
import com.eshop.order.service.CartService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    /***
     * 加入购物车
     * 1.加入购物车数量
     * 2.商品id
     */
    @GetMapping(value = "/add")
    public Result add(Integer num, Long id) {
        cartService.add(num,id,"eshop");
        return new Result(true, StatusCode.OK,"加入购物车成功");
    }
    /***
     * 购物车列表
     */
    @GetMapping(value = "/list")
    public Result<List<OrderItem>> list(){
        //获取用户登录名
        String username = "eshop";
        List<OrderItem> orderItems = cartService.list(username);
        return new Result<List<OrderItem>>(true,StatusCode.OK,"购物车列表查询成功",orderItems);
                //
    }
}
