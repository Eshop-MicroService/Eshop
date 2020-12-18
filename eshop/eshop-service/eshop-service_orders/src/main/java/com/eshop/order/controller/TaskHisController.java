package com.eshop.order.controller;
import com.eshop.order.pojo.TaskHis;
import com.eshop.order.service.TaskHisService;
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
@Api(value = "TaskHisController")
@RestController
@RequestMapping("/taskHis")
@CrossOrigin
public class TaskHisController {

    @Autowired
    private TaskHisService taskHisService;

    /***
     * TaskHis分页条件搜索实现
     * @param taskHis
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TaskHis条件分页查询",notes = "分页条件查询TaskHis方法详情",tags = {"TaskHisController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TaskHis对象",value = "传入JSON数据",required = false) TaskHis taskHis, @PathVariable  int page, @PathVariable  int size){
        //调用TaskHisService实现分页条件查询TaskHis
        PageInfo<TaskHis> pageInfo = taskHisService.findPage(taskHis, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * TaskHis分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TaskHis分页查询",notes = "分页查询TaskHis方法详情",tags = {"TaskHisController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TaskHisService实现分页查询TaskHis
        PageInfo<TaskHis> pageInfo = taskHisService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param taskHis
     * @return
     */
    @ApiOperation(value = "TaskHis条件查询",notes = "条件查询TaskHis方法详情",tags = {"TaskHisController"})
    @PostMapping(value = "/search" )
    public Result<List<TaskHis>> findList(@RequestBody(required = false) @ApiParam(name = "TaskHis对象",value = "传入JSON数据",required = false) TaskHis taskHis){
        //调用TaskHisService实现条件查询TaskHis
        List<TaskHis> list = taskHisService.findList(taskHis);
        return new Result<List<TaskHis>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TaskHis根据ID删除",notes = "根据ID删除TaskHis方法详情",tags = {"TaskHisController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用TaskHisService实现根据主键删除
        taskHisService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改TaskHis数据
     * @param taskHis
     * @param id
     * @return
     */
    @ApiOperation(value = "TaskHis根据ID修改",notes = "根据ID修改TaskHis方法详情",tags = {"TaskHisController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "TaskHis对象",value = "传入JSON数据",required = false) TaskHis taskHis,@PathVariable Long id){
        //设置主键值
        taskHis.setId(id);
        //调用TaskHisService实现修改TaskHis
        taskHisService.update(taskHis);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增TaskHis数据
     * @param taskHis
     * @return
     */
    @ApiOperation(value = "TaskHis添加",notes = "添加TaskHis方法详情",tags = {"TaskHisController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "TaskHis对象",value = "传入JSON数据",required = true) TaskHis taskHis){
        //调用TaskHisService实现添加TaskHis
        taskHisService.add(taskHis);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询TaskHis数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TaskHis根据ID查询",notes = "根据ID查询TaskHis方法详情",tags = {"TaskHisController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<TaskHis> findById(@PathVariable Long id){
        //调用TaskHisService实现根据主键查询TaskHis
        TaskHis taskHis = taskHisService.findById(id);
        return new Result<TaskHis>(true,StatusCode.OK,"查询成功",taskHis);
    }

    /***
     * 查询TaskHis全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TaskHis",notes = "查询所TaskHis有方法详情",tags = {"TaskHisController"})
    @GetMapping
    public Result<List<TaskHis>> findAll(){
        //调用TaskHisService实现查询所有TaskHis
        List<TaskHis> list = taskHisService.findAll();
        return new Result<List<TaskHis>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
