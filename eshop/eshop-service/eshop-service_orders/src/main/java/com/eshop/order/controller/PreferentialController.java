package com.eshop.order.controller;
import com.eshop.order.pojo.Preferential;
import com.eshop.order.service.PreferentialService;
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
@Api(value = "PreferentialController")
@RestController
@RequestMapping("/preferential")
@CrossOrigin
public class PreferentialController {

    @Autowired
    private PreferentialService preferentialService;

    /***
     * Preferential分页条件搜索实现
     * @param preferential
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Preferential条件分页查询",notes = "分页条件查询Preferential方法详情",tags = {"PreferentialController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Preferential对象",value = "传入JSON数据",required = false) Preferential preferential, @PathVariable  int page, @PathVariable  int size){
        //调用PreferentialService实现分页条件查询Preferential
        PageInfo<Preferential> pageInfo = preferentialService.findPage(preferential, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Preferential分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Preferential分页查询",notes = "分页查询Preferential方法详情",tags = {"PreferentialController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PreferentialService实现分页查询Preferential
        PageInfo<Preferential> pageInfo = preferentialService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param preferential
     * @return
     */
    @ApiOperation(value = "Preferential条件查询",notes = "条件查询Preferential方法详情",tags = {"PreferentialController"})
    @PostMapping(value = "/search" )
    public Result<List<Preferential>> findList(@RequestBody(required = false) @ApiParam(name = "Preferential对象",value = "传入JSON数据",required = false) Preferential preferential){
        //调用PreferentialService实现条件查询Preferential
        List<Preferential> list = preferentialService.findList(preferential);
        return new Result<List<Preferential>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Preferential根据ID删除",notes = "根据ID删除Preferential方法详情",tags = {"PreferentialController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PreferentialService实现根据主键删除
        preferentialService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Preferential数据
     * @param preferential
     * @param id
     * @return
     */
    @ApiOperation(value = "Preferential根据ID修改",notes = "根据ID修改Preferential方法详情",tags = {"PreferentialController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Preferential对象",value = "传入JSON数据",required = false) Preferential preferential,@PathVariable Integer id){
        //设置主键值
        preferential.setId(id);
        //调用PreferentialService实现修改Preferential
        preferentialService.update(preferential);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Preferential数据
     * @param preferential
     * @return
     */
    @ApiOperation(value = "Preferential添加",notes = "添加Preferential方法详情",tags = {"PreferentialController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Preferential对象",value = "传入JSON数据",required = true) Preferential preferential){
        //调用PreferentialService实现添加Preferential
        preferentialService.add(preferential);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Preferential数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Preferential根据ID查询",notes = "根据ID查询Preferential方法详情",tags = {"PreferentialController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Preferential> findById(@PathVariable Integer id){
        //调用PreferentialService实现根据主键查询Preferential
        Preferential preferential = preferentialService.findById(id);
        return new Result<Preferential>(true,StatusCode.OK,"查询成功",preferential);
    }

    /***
     * 查询Preferential全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Preferential",notes = "查询所Preferential有方法详情",tags = {"PreferentialController"})
    @GetMapping
    public Result<List<Preferential>> findAll(){
        //调用PreferentialService实现查询所有Preferential
        List<Preferential> list = preferentialService.findAll();
        return new Result<List<Preferential>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
