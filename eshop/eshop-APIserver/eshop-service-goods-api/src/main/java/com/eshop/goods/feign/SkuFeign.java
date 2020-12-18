package com.eshop.goods.feign;
import com.eshop.goods.pojo.Sku;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(value = "goods",name = "goods")
@RequestMapping("/sku")
public interface SkuFeign {

    /***
     * 根据id查询sku数据
     */
    @GetMapping("/{id}")
    public Result<Sku> findById(@PathVariable(value = "id",required = true) Long id);

    /***
     * 查询Sku全部数据
     * @return
     */
    @GetMapping
    Result<List<Sku>> findAll();
}