package com.eshop.order.controller;
import com.eshop.order.pojo.ReturnOrderItem;
import com.eshop.order.service.ReturnOrderItemService;
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
@Api(value = "ReturnOrderItemController")
@RestController
@RequestMapping("/returnOrderItem")
@CrossOrigin
public class ReturnOrderItemController {

    @Autowired
    private ReturnOrderItemService returnOrderItemService;

    /***
     * ReturnOrderItem分页条件搜索实现
     * @param returnOrderItem
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem条件分页查询",notes = "分页条件查询ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "ReturnOrderItem对象",value = "传入JSON数据",required = false) ReturnOrderItem returnOrderItem, @PathVariable  int page, @PathVariable  int size){
        //调用ReturnOrderItemService实现分页条件查询ReturnOrderItem
        PageInfo<ReturnOrderItem> pageInfo = returnOrderItemService.findPage(returnOrderItem, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ReturnOrderItem分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem分页查询",notes = "分页查询ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用ReturnOrderItemService实现分页查询ReturnOrderItem
        PageInfo<ReturnOrderItem> pageInfo = returnOrderItemService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param returnOrderItem
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem条件查询",notes = "条件查询ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @PostMapping(value = "/search" )
    public Result<List<ReturnOrderItem>> findList(@RequestBody(required = false) @ApiParam(name = "ReturnOrderItem对象",value = "传入JSON数据",required = false) ReturnOrderItem returnOrderItem){
        //调用ReturnOrderItemService实现条件查询ReturnOrderItem
        List<ReturnOrderItem> list = returnOrderItemService.findList(returnOrderItem);
        return new Result<List<ReturnOrderItem>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem根据ID删除",notes = "根据ID删除ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用ReturnOrderItemService实现根据主键删除
        returnOrderItemService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改ReturnOrderItem数据
     * @param returnOrderItem
     * @param id
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem根据ID修改",notes = "根据ID修改ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "ReturnOrderItem对象",value = "传入JSON数据",required = false) ReturnOrderItem returnOrderItem,@PathVariable String id){
        //设置主键值
        returnOrderItem.setId(id);
        //调用ReturnOrderItemService实现修改ReturnOrderItem
        returnOrderItemService.update(returnOrderItem);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增ReturnOrderItem数据
     * @param returnOrderItem
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem添加",notes = "添加ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "ReturnOrderItem对象",value = "传入JSON数据",required = true) ReturnOrderItem returnOrderItem){
        //调用ReturnOrderItemService实现添加ReturnOrderItem
        returnOrderItemService.add(returnOrderItem);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询ReturnOrderItem数据
     * @param id
     * @return
     */
    @ApiOperation(value = "ReturnOrderItem根据ID查询",notes = "根据ID查询ReturnOrderItem方法详情",tags = {"ReturnOrderItemController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<ReturnOrderItem> findById(@PathVariable String id){
        //调用ReturnOrderItemService实现根据主键查询ReturnOrderItem
        ReturnOrderItem returnOrderItem = returnOrderItemService.findById(id);
        return new Result<ReturnOrderItem>(true,StatusCode.OK,"查询成功",returnOrderItem);
    }

    /***
     * 查询ReturnOrderItem全部数据
     * @return
     */
    @ApiOperation(value = "查询所有ReturnOrderItem",notes = "查询所ReturnOrderItem有方法详情",tags = {"ReturnOrderItemController"})
    @GetMapping
    public Result<List<ReturnOrderItem>> findAll(){
        //调用ReturnOrderItemService实现查询所有ReturnOrderItem
        List<ReturnOrderItem> list = returnOrderItemService.findAll();
        return new Result<List<ReturnOrderItem>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
