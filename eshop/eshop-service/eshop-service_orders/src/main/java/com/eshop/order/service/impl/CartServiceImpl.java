package com.eshop.order.service.impl;

import com.eshop.goods.feign.SkuFeign;
import com.eshop.goods.feign.SpuFeign;
import com.eshop.goods.pojo.Sku;
import com.eshop.goods.pojo.Spu;
import com.eshop.order.pojo.OrderItem;
import com.eshop.order.service.CartService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    //数据要存入到哪台机器的redis
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private SpuFeign spuFeign;


    /***
     * 购物车集合查询
     * @param username 用户登录名
     * @return
     */
    @Override
    public List<OrderItem> list (String username){
        //获取指定命名空间下所有数据
        return redisTemplate.boundHashOps("Cart_"+username).values();
    }
    /***
     * 加入购物车
     * @param num
     * @param id
     */
    @Override
    public void add(Integer num,Long id,String username) {
        //查询商品详情
        //1.查询sku
        //2.查询spu
        Result<Sku> skuResult = skuFeign.findById(id);
        Sku sku=skuResult.getData();

        Result<Spu> spuResult = spuFeign.findById(sku.getSpuId());
        Spu spu=spuResult.getData();
        //将加入购物车的商品信息封装成OrderItem
        OrderItem orderItem= new OrderItem();
        orderItem.setCategoryId1(spu.getCategory1Id());
        orderItem.setCategoryId2(spu.getCategory2Id());
        orderItem.setCategoryId3(spu.getCategory3Id());
        orderItem.setSkuId(spu.getId().toString());
        orderItem.setSkuId(id.toString());
        orderItem.setName(sku.getName());
        orderItem.setPrice(sku.getPrice());
        orderItem.setNum(num);
        orderItem.setMoney(num*orderItem.getPrice());
        orderItem.setImage(spu.getImage());

        //将购物车数据存入redis：namespace->username
        redisTemplate.boundHashOps("Cart_"+username).put(id,orderItem);
    }
}
