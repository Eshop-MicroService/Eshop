package com.eshop.order.controller;
import com.eshop.order.pojo.CategoryReport;
import com.eshop.order.service.CategoryReportService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Api(value = "CategoryReportController")
@RestController
@RequestMapping("/categoryReport")
@CrossOrigin
public class CategoryReportController {

    @Autowired
    private CategoryReportService categoryReportService;

    /***
     * CategoryReport分页条件搜索实现
     * @param categoryReport
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "CategoryReport条件分页查询",notes = "分页条件查询CategoryReport方法详情",tags = {"CategoryReportController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "CategoryReport对象",value = "传入JSON数据",required = false) CategoryReport categoryReport, @PathVariable  int page, @PathVariable  int size){
        //调用CategoryReportService实现分页条件查询CategoryReport
        PageInfo<CategoryReport> pageInfo = categoryReportService.findPage(categoryReport, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * CategoryReport分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "CategoryReport分页查询",notes = "分页查询CategoryReport方法详情",tags = {"CategoryReportController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用CategoryReportService实现分页查询CategoryReport
        PageInfo<CategoryReport> pageInfo = categoryReportService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param categoryReport
     * @return
     */
    @ApiOperation(value = "CategoryReport条件查询",notes = "条件查询CategoryReport方法详情",tags = {"CategoryReportController"})
    @PostMapping(value = "/search" )
    public Result<List<CategoryReport>> findList(@RequestBody(required = false) @ApiParam(name = "CategoryReport对象",value = "传入JSON数据",required = false) CategoryReport categoryReport){
        //调用CategoryReportService实现条件查询CategoryReport
        List<CategoryReport> list = categoryReportService.findList(categoryReport);
        return new Result<List<CategoryReport>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "CategoryReport根据ID删除",notes = "根据ID删除CategoryReport方法详情",tags = {"CategoryReportController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Date")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Date id){
        //调用CategoryReportService实现根据主键删除
        categoryReportService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改CategoryReport数据
     * @param categoryReport
     * @param id
     * @return
     */
    @ApiOperation(value = "CategoryReport根据ID修改",notes = "根据ID修改CategoryReport方法详情",tags = {"CategoryReportController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Date")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "CategoryReport对象",value = "传入JSON数据",required = false) CategoryReport categoryReport,@PathVariable Date id){
        //设置主键值
        categoryReport.setCountDate(id);
        //调用CategoryReportService实现修改CategoryReport
        categoryReportService.update(categoryReport);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增CategoryReport数据
     * @param categoryReport
     * @return
     */
    @ApiOperation(value = "CategoryReport添加",notes = "添加CategoryReport方法详情",tags = {"CategoryReportController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "CategoryReport对象",value = "传入JSON数据",required = true) CategoryReport categoryReport){
        //调用CategoryReportService实现添加CategoryReport
        categoryReportService.add(categoryReport);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询CategoryReport数据
     * @param id
     * @return
     */
    @ApiOperation(value = "CategoryReport根据ID查询",notes = "根据ID查询CategoryReport方法详情",tags = {"CategoryReportController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Date")
    @GetMapping("/{id}")
    public Result<CategoryReport> findById(@PathVariable Date id){
        //调用CategoryReportService实现根据主键查询CategoryReport
        CategoryReport categoryReport = categoryReportService.findById(id);
        return new Result<CategoryReport>(true,StatusCode.OK,"查询成功",categoryReport);
    }

    /***
     * 查询CategoryReport全部数据
     * @return
     */
    @ApiOperation(value = "查询所有CategoryReport",notes = "查询所CategoryReport有方法详情",tags = {"CategoryReportController"})
    @GetMapping
    public Result<List<CategoryReport>> findAll(){
        //调用CategoryReportService实现查询所有CategoryReport
        List<CategoryReport> list = categoryReportService.findAll();
        return new Result<List<CategoryReport>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
