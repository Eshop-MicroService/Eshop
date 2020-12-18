package com.eshop.goods.controller;

import com.eshop.goods.pojo.Sku;
import com.eshop.goods.service.SkuService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "SkuController")
@RestController
@RequestMapping("/sku")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    /***
     * Sku分页条件搜索实现
     * @param sku
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Sku条件分页查询",notes = "分页条件查询Sku方法详情",tags = {"SkuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Sku对象",value = "传入JSON数据",required = false) Sku sku, @PathVariable  int page, @PathVariable  int size){
        //调用SkuService实现分页条件查询Sku
        PageInfo<Sku> pageInfo = skuService.findPage(sku, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Sku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Sku分页查询",notes = "分页查询Sku方法详情",tags = {"SkuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SkuService实现分页查询Sku
        PageInfo<Sku> pageInfo = skuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sku
     * @return
     */
    @ApiOperation(value = "Sku条件查询",notes = "条件查询Sku方法详情",tags = {"SkuController"})
    @PostMapping(value = "/search" )
    public Result<List<Sku>> findList(@RequestBody(required = false) @ApiParam(name = "Sku对象",value = "传入JSON数据",required = false) Sku sku){
        //调用SkuService实现条件查询Sku
        List<Sku> list = skuService.findList(sku);
        return new Result<List<Sku>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Sku根据ID删除",notes = "根据ID删除Sku方法详情",tags = {"SkuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SkuService实现根据主键删除
        skuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Sku数据
     * @param sku
     * @param id
     * @return
     */
    @ApiOperation(value = "Sku根据ID修改",notes = "根据ID修改Sku方法详情",tags = {"SkuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Sku对象",value = "传入JSON数据",required = false) Sku sku,@PathVariable Long id){
        //设置主键值
        sku.setId(id);
        //调用SkuService实现修改Sku
        skuService.update(sku);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Sku数据
     * @param sku
     * @return
     */
    @ApiOperation(value = "Sku添加",notes = "添加Sku方法详情",tags = {"SkuController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Sku对象",value = "传入JSON数据",required = true) Sku sku){
        //调用SkuService实现添加Sku
        skuService.add(sku);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Sku数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Sku根据ID查询",notes = "根据ID查询Sku方法详情",tags = {"SkuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Sku> findById(@PathVariable Long id){
        //调用SkuService实现根据主键查询Sku
        Sku sku = skuService.findById(id);
        return new Result<Sku>(true,StatusCode.OK,"查询成功",sku);
    }

    /***
     * 查询Sku全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Sku",notes = "查询所Sku有方法详情",tags = {"SkuController"})
    @GetMapping
    public Result<List<Sku>> findAll(){
        //调用SkuService实现查询所有Sku
        List<Sku> list = skuService.findAll();
        return new Result<List<Sku>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
