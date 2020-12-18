package com.eshop.order.controller;
import com.eshop.order.pojo.OrderConfig;
import com.eshop.order.service.OrderConfigService;
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
@Api(value = "OrderConfigController")
@RestController
@RequestMapping("/orderConfig")
@CrossOrigin
public class OrderConfigController {

    @Autowired
    private OrderConfigService orderConfigService;

    /***
     * OrderConfig分页条件搜索实现
     * @param orderConfig
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OrderConfig条件分页查询",notes = "分页条件查询OrderConfig方法详情",tags = {"OrderConfigController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OrderConfig对象",value = "传入JSON数据",required = false) OrderConfig orderConfig, @PathVariable  int page, @PathVariable  int size){
        //调用OrderConfigService实现分页条件查询OrderConfig
        PageInfo<OrderConfig> pageInfo = orderConfigService.findPage(orderConfig, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OrderConfig分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OrderConfig分页查询",notes = "分页查询OrderConfig方法详情",tags = {"OrderConfigController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OrderConfigService实现分页查询OrderConfig
        PageInfo<OrderConfig> pageInfo = orderConfigService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param orderConfig
     * @return
     */
    @ApiOperation(value = "OrderConfig条件查询",notes = "条件查询OrderConfig方法详情",tags = {"OrderConfigController"})
    @PostMapping(value = "/search" )
    public Result<List<OrderConfig>> findList(@RequestBody(required = false) @ApiParam(name = "OrderConfig对象",value = "传入JSON数据",required = false) OrderConfig orderConfig){
        //调用OrderConfigService实现条件查询OrderConfig
        List<OrderConfig> list = orderConfigService.findList(orderConfig);
        return new Result<List<OrderConfig>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OrderConfig根据ID删除",notes = "根据ID删除OrderConfig方法详情",tags = {"OrderConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用OrderConfigService实现根据主键删除
        orderConfigService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OrderConfig数据
     * @param orderConfig
     * @param id
     * @return
     */
    @ApiOperation(value = "OrderConfig根据ID修改",notes = "根据ID修改OrderConfig方法详情",tags = {"OrderConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "OrderConfig对象",value = "传入JSON数据",required = false) OrderConfig orderConfig,@PathVariable Integer id){
        //设置主键值
        orderConfig.setId(id);
        //调用OrderConfigService实现修改OrderConfig
        orderConfigService.update(orderConfig);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OrderConfig数据
     * @param orderConfig
     * @return
     */
    @ApiOperation(value = "OrderConfig添加",notes = "添加OrderConfig方法详情",tags = {"OrderConfigController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "OrderConfig对象",value = "传入JSON数据",required = true) OrderConfig orderConfig){
        //调用OrderConfigService实现添加OrderConfig
        orderConfigService.add(orderConfig);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OrderConfig数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OrderConfig根据ID查询",notes = "根据ID查询OrderConfig方法详情",tags = {"OrderConfigController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<OrderConfig> findById(@PathVariable Integer id){
        //调用OrderConfigService实现根据主键查询OrderConfig
        OrderConfig orderConfig = orderConfigService.findById(id);
        return new Result<OrderConfig>(true,StatusCode.OK,"查询成功",orderConfig);
    }

    /***
     * 查询OrderConfig全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OrderConfig",notes = "查询所OrderConfig有方法详情",tags = {"OrderConfigController"})
    @GetMapping
    public Result<List<OrderConfig>> findAll(){
        //调用OrderConfigService实现查询所有OrderConfig
        List<OrderConfig> list = orderConfigService.findAll();
        return new Result<List<OrderConfig>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
