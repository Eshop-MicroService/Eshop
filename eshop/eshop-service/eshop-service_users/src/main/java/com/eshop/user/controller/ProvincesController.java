package com.eshop.user.controller;
import com.eshop.user.pojo.Provinces;
import com.eshop.user.service.ProvincesService;
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
@Api(value = "ProvincesController")
@RestController
@RequestMapping("/provinces")
@CrossOrigin
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;

    /***
     * Provinces分页条件搜索实现
     * @param provinces
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Provinces条件分页查询",notes = "分页条件查询Provinces方法详情",tags = {"ProvincesController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Provinces对象",value = "传入JSON数据",required = false) Provinces provinces, @PathVariable  int page, @PathVariable  int size){
        //调用ProvincesService实现分页条件查询Provinces
        PageInfo<Provinces> pageInfo = provincesService.findPage(provinces, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Provinces分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Provinces分页查询",notes = "分页查询Provinces方法详情",tags = {"ProvincesController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ProvincesService实现分页查询Provinces
        PageInfo<Provinces> pageInfo = provincesService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param provinces
     * @return
     */
    @ApiOperation(value = "Provinces条件查询",notes = "条件查询Provinces方法详情",tags = {"ProvincesController"})
    @PostMapping(value = "/search" )
    public Result<List<Provinces>> findList(@RequestBody(required = false) @ApiParam(name = "Provinces对象",value = "传入JSON数据",required = false) Provinces provinces){
        //调用ProvincesService实现条件查询Provinces
        List<Provinces> list = provincesService.findList(provinces);
        return new Result<List<Provinces>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Provinces根据ID删除",notes = "根据ID删除Provinces方法详情",tags = {"ProvincesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用ProvincesService实现根据主键删除
        provincesService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Provinces数据
     * @param provinces
     * @param id
     * @return
     */
    @ApiOperation(value = "Provinces根据ID修改",notes = "根据ID修改Provinces方法详情",tags = {"ProvincesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Provinces对象",value = "传入JSON数据",required = false) Provinces provinces,@PathVariable String id){
        //设置主键值
        provinces.setProvinceid(id);
        //调用ProvincesService实现修改Provinces
        provincesService.update(provinces);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Provinces数据
     * @param provinces
     * @return
     */
    @ApiOperation(value = "Provinces添加",notes = "添加Provinces方法详情",tags = {"ProvincesController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Provinces对象",value = "传入JSON数据",required = true) Provinces provinces){
        //调用ProvincesService实现添加Provinces
        provincesService.add(provinces);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Provinces数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Provinces根据ID查询",notes = "根据ID查询Provinces方法详情",tags = {"ProvincesController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Provinces> findById(@PathVariable String id){
        //调用ProvincesService实现根据主键查询Provinces
        Provinces provinces = provincesService.findById(id);
        return new Result<Provinces>(true,StatusCode.OK,"查询成功",provinces);
    }

    /***
     * 查询Provinces全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Provinces",notes = "查询所Provinces有方法详情",tags = {"ProvincesController"})
    @GetMapping
    public Result<List<Provinces>> findAll(){
        //调用ProvincesService实现查询所有Provinces
        List<Provinces> list = provincesService.findAll();
        return new Result<List<Provinces>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
