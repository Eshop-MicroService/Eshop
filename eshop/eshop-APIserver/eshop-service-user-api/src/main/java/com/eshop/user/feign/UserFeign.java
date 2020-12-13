package com.eshop.user.feign;

import com.eshop.user.pojo.User;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user")
@RequestMapping(value = "/user")
public interface UserFeign {
    /***
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping({"/load/{id}"})
     Result<User> findById(@PathVariable String id);
}
