package com.eshop.order.controller;
import com.eshop.order.pojo.Task;
import com.eshop.order.service.TaskService;
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
@Api(value = "TaskController")
@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    /***
     * Task分页条件搜索实现
     * @param task
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Task条件分页查询",notes = "分页条件查询Task方法详情",tags = {"TaskController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Task对象",value = "传入JSON数据",required = false) Task task, @PathVariable  int page, @PathVariable  int size){
        //调用TaskService实现分页条件查询Task
        PageInfo<Task> pageInfo = taskService.findPage(task, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Task分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Task分页查询",notes = "分页查询Task方法详情",tags = {"TaskController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用TaskService实现分页查询Task
        PageInfo<Task> pageInfo = taskService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param task
     * @return
     */
    @ApiOperation(value = "Task条件查询",notes = "条件查询Task方法详情",tags = {"TaskController"})
    @PostMapping(value = "/search" )
    public Result<List<Task>> findList(@RequestBody(required = false) @ApiParam(name = "Task对象",value = "传入JSON数据",required = false) Task task){
        //调用TaskService实现条件查询Task
        List<Task> list = taskService.findList(task);
        return new Result<List<Task>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Task根据ID删除",notes = "根据ID删除Task方法详情",tags = {"TaskController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用TaskService实现根据主键删除
        taskService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Task数据
     * @param task
     * @param id
     * @return
     */
    @ApiOperation(value = "Task根据ID修改",notes = "根据ID修改Task方法详情",tags = {"TaskController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Task对象",value = "传入JSON数据",required = false) Task task,@PathVariable Long id){
        //设置主键值
        task.setId(id);
        //调用TaskService实现修改Task
        taskService.update(task);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Task数据
     * @param task
     * @return
     */
    @ApiOperation(value = "Task添加",notes = "添加Task方法详情",tags = {"TaskController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Task对象",value = "传入JSON数据",required = true) Task task){
        //调用TaskService实现添加Task
        taskService.add(task);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Task数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Task根据ID查询",notes = "根据ID查询Task方法详情",tags = {"TaskController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<Task> findById(@PathVariable Long id){
        //调用TaskService实现根据主键查询Task
        Task task = taskService.findById(id);
        return new Result<Task>(true,StatusCode.OK,"查询成功",task);
    }

    /***
     * 查询Task全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Task",notes = "查询所Task有方法详情",tags = {"TaskController"})
    @GetMapping
    public Result<List<Task>> findAll(){
        //调用TaskService实现查询所有Task
        List<Task> list = taskService.findAll();
        return new Result<List<Task>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
