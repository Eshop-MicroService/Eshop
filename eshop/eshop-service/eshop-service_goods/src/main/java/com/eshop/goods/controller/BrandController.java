package com.eshop.goods.controller;

import com.eshop.goods.pojo.Brand;
import com.eshop.goods.service.BrandService;
import com.github.pagehelper.PageInfo;



import entity.Result;
import entity.StatusCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin

@Api(tags = "品牌操作接口")
public class BrandController {
    @Autowired
    private BrandService brandService;


    /***
     * Brand分页条件搜索实现
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable int page, @PathVariable int size) {
        //调用BrandService实现分页条件查询Brand
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * Brand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用BrandService实现分页查询Brand
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand) {
        //调用BrandService实现条件查询Brand
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     */
    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        //调用BrandService实现根据主键删除
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改Brand数据
     */
    @PutMapping(value = "/put/{id}")
    public Result update(@RequestBody Brand brand, @PathVariable Integer id) {
        //设置主键值
        brand.setId(id);
        //调用BrandService实现修改Brand
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增Brand数据
     */
    @PostMapping("/add")
    public Result add(@RequestBody   Brand brand){
        //调用BrandService实现添加Brand
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 根据ID查询Brand数据
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        //调用BrandService实现根据主键查询Brand
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "查询成功", brand);
    }

    /***
     * 查询Brand全部数据
     */
    @ApiOperation(value = "查询全部品牌")
    @GetMapping
    public Result<List<Brand>> findAll() {
        //调用BrandService实现查询所有Brand
        List<Brand> list = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK, "查询成功", list);
    }


    /**
     * @return
     */
    @GetMapping("/category/{id}")
    public Result<List<Brand>> findBrandByCategory(@PathVariable(name = "id") Integer id) {
        List<Brand> brandList = brandService.findByCategory(id);

        return new Result<List<Brand>>(true, StatusCode.OK, "查询品牌列表成功", brandList);

    }
}