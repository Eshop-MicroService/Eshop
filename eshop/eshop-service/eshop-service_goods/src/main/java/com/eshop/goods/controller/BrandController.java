package com.eshop.goods.controller;


import com.eshop.goods.pojo.Brand;
import com.eshop.goods.service.BrandService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
@Api
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    @ApiOperation(value = "查询品牌", notes = "查询品牌")
    public Result<List<Brand>> findAll() {
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"success!",brands);
    }
}
