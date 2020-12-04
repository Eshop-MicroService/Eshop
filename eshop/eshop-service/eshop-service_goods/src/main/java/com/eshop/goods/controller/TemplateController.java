package com.eshop.goods.controller;
import com.eshop.goods.pojo.Template;
import com.eshop.goods.service.TemplateService;
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
@RequestMapping(value = "/template")
@CrossOrigin
@Api(tags = "模板查询")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /***
     * Template分页条件搜索实现
     * @param template
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页条件搜索实现")
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  Template template, @PathVariable  int page, @PathVariable  int size){
        //调用TemplateService实现分页条件查询Template
        PageInfo<Template> pageInfo = templateService.findPage(template, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Template分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Template分页搜索实现")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TemplateService实现分页查询Template
        PageInfo<Template> pageInfo = templateService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }
    /***
     * 多条件搜索品牌数据
     * @param template
     * @return
     */
    @ApiOperation(value = "多条件搜索品牌数据")
    @PostMapping(value = "/search" )
    public Result<List<Template>> findList(@RequestBody(required = false)  Template template){
        //调用TemplateService实现条件查询Template
        List<Template> list = templateService.findList(template);
        return new Result<List<Template>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除品牌数据")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用TemplateService实现根据主键删除
        templateService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Template数据
     * @param template
     * @param id
     * @return
     */
    @ApiOperation(value = "修改Template数据")
    @PutMapping("/{id}")
    public Result update(@RequestBody  Template template,@PathVariable Integer id){
        //设置主键值
        template.setId(id);
        //调用TemplateService实现修改Template
        templateService.update(template);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Template数据
     * @param template
     * @return
     */
    @ApiOperation(value = "新增Template数据")
    @PostMapping
    public Result add(@RequestBody   Template template){
        //调用TemplateService实现添加Template
        templateService.add(template);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Template数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID查询Template数据")
    @GetMapping("/{id}")
    public Result<Template> findById(@PathVariable Integer id){
        //调用TemplateService实现根据主键查询Template
        Template template = templateService.findById(id);
        return new Result<Template>(true,StatusCode.OK,"查询成功",template);
    }

    /***
     * 查询Template全部数据
     * @return
     */
    @ApiOperation(value = "查询Template全部数据")
    @GetMapping
    public Result<List<Template>> findAll(){
        //调用TemplateService实现查询所有Template
        List<Template> list = templateService.findAll();
        return new Result<List<Template>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
