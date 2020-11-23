package com.eshop.goods.controller;

import com.eshop.goods.pojo.Goods;
import com.eshop.goods.service.SpuService;
import com.netflix.discovery.converters.Auto;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;


    /***
     * 审核操作
     * @param spuId
     * @return
     */
    @GetMapping(value = "audit/{id}")
    public Result audit(@PathVariable(value = "id")Long spuId) {
        spuService.audit(spuId);
        return new Result(true,StatusCode.OK,"success!");
    }


    /***
     * 上架操作
     */
    @PutMapping(value = "/put/{id}")
    public Result put(@PathVariable(value = "id")Long spuId) {
        spuService.put(spuId);
        return new Result(true,StatusCode.OK,"success!");
    }

    /***
     * 批量上架
     * @param ids
     * @return
     */
    @PutMapping("/put/many")
    @ApiOperation("下架操作")
    public Result putMany(@RequestBody Long[] ids){
        spuService.putMany(ids);
        return new Result(true,StatusCode.OK,"success!");
    }


    /***
     * 下架操作
     * @param spuId
     * @return
     */
    @GetMapping(value = "pull/{id}")
    public Result pull(@PathVariable(value = "id")Long spuId) {
        spuService.pull(spuId);
        return new Result(true,StatusCode.OK,"success!");
    }

    /***
     * 根据id查询商品
     * @param spuId
     * @return
     */
    @GetMapping(value = "/goods/{id}")
    public Result<Goods> findGoodsById(@PathVariable(value = "id")Long spuId) {
        Goods goods = spuService.findGoodsById(spuId);
        return new Result<Goods>(true, StatusCode.OK,"success!",goods);
    }

    /***
     * 修改商品信息
     * @param goods
     * @return
     */
    @PostMapping("/save")
    public Result saveGoods(@RequestBody Goods goods) {
        spuService.saveGoods(goods);
        return new Result(true,StatusCode.OK,"success!");
    }
}
