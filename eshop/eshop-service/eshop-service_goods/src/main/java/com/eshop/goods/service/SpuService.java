package com.eshop.goods.service;

import com.eshop.goods.pojo.Goods;
import com.eshop.goods.pojo.Goods;
import com.eshop.goods.pojo.Spu;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SpuService {

    /***
     * 商品审核
     */
    void audit(Long spuid);

    /***
     * 商品下架
     */
    void pull(Long spuid);

    /***
     * 商品上架
     */
    void put(Long spuid);

    /***
     * 批量上架
     * @param ids [] 要上架的所有商品ID(spuId)
     */
    void putMany(Long[] ids);

    /***
     * 根据id查询Goods
     * @param id
     */
    Goods findGoodsById(Long id);

    /***
     * 商品增加
     */
    void saveGoods(Goods goods);
    /***
     * Spu多条件分页查询
     * @param spu
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    /***
     * Spu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(int page, int size);

    /***
     * Spu多条件搜索方法
     * @param spu
     * @return
     */
    List<Spu> findList(Spu spu);

    /***
     * 删除Spu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Spu数据
     * @param spu
     */
    void update(Spu spu);

    /***
     * 新增Spu
     * @param spu
     */
    void add(Spu spu);

    /**
     * 根据ID查询Spu
     * @param id
     * @return
     */
    Spu findById(Long id);

    /***
     * 查询所有Spu
     * @return
     */
    List<Spu> findAll();

    /**
     * 添加商品(SPU+ SKUlIST)
     * @param goods   update  add
     */
    void save(Goods goods);


    void auditSpu(Long id);

    /**
     * 下架
     * @param id
     */
    void pullSpu(Long id);

    void logicDeleteSpu(Long id);


    void restoreSpu(Long id);
}
