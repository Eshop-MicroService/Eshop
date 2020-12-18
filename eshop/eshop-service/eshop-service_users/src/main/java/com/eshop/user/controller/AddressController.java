package com.eshop.user.controller;
import com.eshop.user.pojo.Address;
import com.eshop.user.service.AddressService;
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
 *****/
@Api(value = "AddressController")
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    /***
     * Address分页条件搜索实现
     * @param address
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Address条件分页查询",notes = "分页条件查询Address方法详情",tags = {"AddressController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Address对象",value = "传入JSON数据",required = false) Address address, @PathVariable  int page, @PathVariable  int size){
        //调用AddressService实现分页条件查询Address
        PageInfo<Address> pageInfo = addressService.findPage(address, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Address分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Address分页查询",notes = "分页查询Address方法详情",tags = {"AddressController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AddressService实现分页查询Address
        PageInfo<Address> pageInfo = addressService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param address
     * @return
     */
    @ApiOperation(value = "Address条件查询",notes = "条件查询Address方法详情",tags = {"AddressController"})
    @PostMapping(value = "/search" )
    public Result<List<Address>> findList(@RequestBody(required = false) @ApiParam(name = "Address对象",value = "传入JSON数据",required = false) Address address){
        //调用AddressService实现条件查询Address
        List<Address> list = addressService.findList(address);
        return new Result<List<Address>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Address根据ID删除",notes = "根据ID删除Address方法详情",tags = {"AddressController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AddressService实现根据主键删除
        addressService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Address数据
     * @param address
     * @param id
     * @return
     */
    @ApiOperation(value = "Address根据ID修改",notes = "根据ID修改Address方法详情",tags = {"AddressController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Address对象",value = "传入JSON数据",required = false) Address address,@PathVariable Integer id){
        //设置主键值
        address.setId(id);
        //调用AddressService实现修改Address
        addressService.update(address);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Address数据
     * @param address
     * @return
     */
    @ApiOperation(value = "Address添加",notes = "添加Address方法详情",tags = {"AddressController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Address对象",value = "传入JSON数据",required = true) Address address){
        //调用AddressService实现添加Address
        addressService.add(address);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Address数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Address根据ID查询",notes = "根据ID查询Address方法详情",tags = {"AddressController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Address> findById(@PathVariable Integer id){
        //调用AddressService实现根据主键查询Address
        Address address = addressService.findById(id);
        return new Result<Address>(true,StatusCode.OK,"查询成功",address);
    }

    /***
     * 查询Address全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Address",notes = "查询所Address有方法详情",tags = {"AddressController"})
    @GetMapping
    public Result<List<Address>> findAll(){
        //调用AddressService实现查询所有Address
        List<Address> list = addressService.findAll();
        return new Result<List<Address>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
