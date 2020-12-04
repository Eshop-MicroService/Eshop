package com.eshop.goods.controller;
import com.eshop.goods.pojo.Goods;
import com.eshop.goods.pojo.Spu;
import com.eshop.goods.service.SpuService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/spu")
@CrossOrigin
@Api(tags = "SPU+SKU保存 ")
public class SpuController {

    @Autowired
    private SpuService spuService;

    /***
     * Spu分页条件搜索实现
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Spu分页条件搜索实现")
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  Spu spu, @PathVariable  int page, @PathVariable  int size){
        //调用SpuService实现分页条件查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Spu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Spu分页搜索实现")

    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SpuService实现分页查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param spu
     * @return
     */
    @ApiOperation(value = "多条件搜索品牌数据")

    @PostMapping(value = "/search" )
    public Result<List<Spu>> findList(@RequestBody(required = false)  Spu spu){
        //调用SpuService实现条件查询Spu
        List<Spu> list = spuService.findList(spu);
        return new Result<List<Spu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除品牌数据")

    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用SpuService实现根据主键删除
        spuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Spu数据
     * @param spu
     * @param id
     * @return
     */
    @ApiOperation(value = "修改Spu数据")

    @PutMapping(value="/{id}")
    public Result update(@RequestBody  Spu spu,@PathVariable Long id){
        //设置主键值
        spu.setId(id);
        //调用SpuService实现修改Spu
        spuService.update(spu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Spu数据
     * @param spu
     * @return
     */
    @ApiOperation(value = "新增Spu数据")

    @PostMapping
    public Result add(@RequestBody   Spu spu){
        //调用SpuService实现添加Spu
        spuService.add(spu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Spu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID查询Spu数据")

    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable Long id){
        //调用SpuService实现根据主键查询Spu
        Spu spu = spuService.findById(id);
        return new Result<Spu>(true,StatusCode.OK,"查询成功",spu);
    }

    /***
     * 查询Spu全部数据
     * @return
     */
    @ApiOperation(value = "查询Spu全部数据")

    @GetMapping
    public Result<List<Spu>> findAll(){
        //调用SpuService实现查询所有Spu
        List<Spu> list = spuService.findAll();
        return new Result<List<Spu>>(true, StatusCode.OK,"查询成功",list) ;
    }

    /**
     * Goods(SPU+SKU)增加方法详情
     */
    @ApiOperation(value = "Goods增加方法")

    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        spuService.saveGoods(goods);
        return new Result(true,StatusCode.OK,"保存商品成功",null);
    }

    @ApiOperation(value = "查询goods数据")
    //根据点击到的商品(SPU)的ID 获取到GOODS数据返回给页面展示
    @GetMapping("/goods/{id}")
    public Result<Goods> findGoodsById(@PathVariable(value="id") Long id){
        Goods goods = spuService.findGoodsById(id);
        return new Result<Goods>(true,StatusCode.OK,"查询goods数据成功",goods);
    }



    /**
     * //审核商品 自动上架
     * @param id  spu的ID
     * @return
     */
    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable(name="id")Long id){
        spuService.audit(id);
        return new Result(true,StatusCode.OK,"审核通过");
    }

    @PutMapping("/pull/{id}")
    public Result pull(@PathVariable(name="id")Long id){
        spuService.pull(id);
        return new Result(true,StatusCode.OK,"下架成功");
    }

    @DeleteMapping("/logic/delete/{id}")
    public Result logicDeleteSpu(@PathVariable(name="id")Long id){
        spuService.logicDeleteSpu(id);
        return new Result(true,StatusCode.OK,"逻辑删除成功");
    }

    @PutMapping("/restore/{id}")
    public Result restore(@PathVariable(name="id")Long id){
        spuService.restoreSpu(id);
        return new Result(true,StatusCode.OK,"还原成功");
    }




}

