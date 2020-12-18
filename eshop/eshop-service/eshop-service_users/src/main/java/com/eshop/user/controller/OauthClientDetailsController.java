package com.eshop.user.controller;
import com.eshop.user.pojo.OauthClientDetails;
import com.eshop.user.service.OauthClientDetailsService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "OauthClientDetailsController")
@RestController
@RequestMapping("/oauthClientDetails")
@CrossOrigin
public class OauthClientDetailsController {

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;

    /***
     * OauthClientDetails分页条件搜索实现
     * @param oauthClientDetails
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OauthClientDetails条件分页查询",notes = "分页条件查询OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OauthClientDetails对象",value = "传入JSON数据",required = false) OauthClientDetails oauthClientDetails, @PathVariable  int page, @PathVariable  int size){
        //调用OauthClientDetailsService实现分页条件查询OauthClientDetails
        PageInfo<OauthClientDetails> pageInfo = oauthClientDetailsService.findPage(oauthClientDetails, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthClientDetails分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OauthClientDetails分页查询",notes = "分页查询OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthClientDetailsService实现分页查询OauthClientDetails
        PageInfo<OauthClientDetails> pageInfo = oauthClientDetailsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthClientDetails
     * @return
     */
    @ApiOperation(value = "OauthClientDetails条件查询",notes = "条件查询OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @PostMapping(value = "/search" )
    public Result<List<OauthClientDetails>> findList(@RequestBody(required = false) @ApiParam(name = "OauthClientDetails对象",value = "传入JSON数据",required = false) OauthClientDetails oauthClientDetails){
        //调用OauthClientDetailsService实现条件查询OauthClientDetails
        List<OauthClientDetails> list = oauthClientDetailsService.findList(oauthClientDetails);
        return new Result<List<OauthClientDetails>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthClientDetails根据ID删除",notes = "根据ID删除OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OauthClientDetailsService实现根据主键删除
        oauthClientDetailsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OauthClientDetails数据
     * @param oauthClientDetails
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthClientDetails根据ID修改",notes = "根据ID修改OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "OauthClientDetails对象",value = "传入JSON数据",required = false) OauthClientDetails oauthClientDetails,@PathVariable String id){
        //设置主键值
        oauthClientDetails.setClientId(id);
        //调用OauthClientDetailsService实现修改OauthClientDetails
        oauthClientDetailsService.update(oauthClientDetails);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OauthClientDetails数据
     * @param oauthClientDetails
     * @return
     */
    @ApiOperation(value = "OauthClientDetails添加",notes = "添加OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "OauthClientDetails对象",value = "传入JSON数据",required = true) OauthClientDetails oauthClientDetails){
        //调用OauthClientDetailsService实现添加OauthClientDetails
        oauthClientDetailsService.add(oauthClientDetails);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OauthClientDetails数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthClientDetails根据ID查询",notes = "根据ID查询OauthClientDetails方法详情",tags = {"OauthClientDetailsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<OauthClientDetails> findById(@PathVariable String id){
        //调用OauthClientDetailsService实现根据主键查询OauthClientDetails
        OauthClientDetails oauthClientDetails = oauthClientDetailsService.findById(id);
        return new Result<OauthClientDetails>(true,StatusCode.OK,"查询成功",oauthClientDetails);
    }

    /***
     * 查询OauthClientDetails全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OauthClientDetails",notes = "查询所OauthClientDetails有方法详情",tags = {"OauthClientDetailsController"})
    @GetMapping
    public Result<List<OauthClientDetails>> findAll(){
        //调用OauthClientDetailsService实现查询所有OauthClientDetails
        List<OauthClientDetails> list = oauthClientDetailsService.findAll();
        return new Result<List<OauthClientDetails>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
