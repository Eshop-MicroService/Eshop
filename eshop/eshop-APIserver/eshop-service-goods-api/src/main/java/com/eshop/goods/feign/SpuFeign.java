package com.eshop.goods.feign;

import com.eshop.goods.pojo.Spu;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "goods",name = "goods")
@RequestMapping("/spu")
public interface SpuFeign {
    @GetMapping(value = "/{id}")
    Result<Spu> findById(@PathVariable(name = "id") Long id);
}
