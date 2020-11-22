package com.eshop.goods.service;

import com.eshop.goods.pojo.Goods;

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
}
