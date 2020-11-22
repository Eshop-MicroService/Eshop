package com.eshop.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.eshop.goods.mapper.BrandMapper;
import com.eshop.goods.mapper.CategoryMapper;
import com.eshop.goods.mapper.SkuMapper;
import com.eshop.goods.mapper.SpuMapper;
import com.eshop.goods.pojo.*;
import com.eshop.goods.service.SpuService;


import entity.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * bug:
 * idWorker.nextId()
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;




    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SkuMapper skuMapper;


    private IdWorker idWorker;

    /***
     * 商品审核
     * @param spuid
     */
    @Override
    public void audit(Long spuid) {
        //查询商品
        Spu spu = spuMapper.selectByPrimaryKey(spuid);

        //判断商品是否符合审核条件
        if(spu.getIsDelete().equalsIgnoreCase("1")) {
            throw new RuntimeException("不能对已删除的商品进行审核！");
        }

        //审核改状态
        spu.setStatus("1");
        spu.setIsMarketable("1");
        spuMapper.updateByPrimaryKeySelective(spu);
    }


    /***
     * 商品上架
     * @param spuId
     */
    @Override
    public void put(Long spuId) {
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        //检查是否删除的商品
        if(spu.getIsDelete().equals("1")){
            throw new RuntimeException("此商品已删除！");
        }
        if(!spu.getStatus().equals("1")){
            throw new RuntimeException("未通过审核的商品不能！");
        }
        //上架状态
        spu.setIsMarketable("1");
        spuMapper.updateByPrimaryKeySelective(spu);
    }


    /***
     * 批量上架
     * @param ids []
     */
    @Override
    public void putMany(Long[] ids){


        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();

        //在ids中
        criteria.andIn("id", Arrays.asList(ids));
        //未删除 已审核
        criteria.andEqualTo("isDelete","0");
        criteria.andEqualTo("status","1");

        //准备修改的数据
        Spu spu = new Spu();
        spu.setIsMarketable("1");
        spuMapper.updateByExampleSelective(spu,example);
    }


    /***
     * 商品下架
     * @param spuId
     */
    @Override
    public void pull(Long spuId) {
        Spu spu=spuMapper.selectByPrimaryKey(spuId);
        if(spu.getIsDelete().equals("1")){
            throw new RuntimeException("此商品已删除！");

        }
        spu.setIsMarketable("0");//下架
        spuMapper.updateByPrimaryKeySelective(spu);
    }




    /***
     * 根据id查询Goods
     * @param id
     * @return
     */
    @Override
    public Goods findGoodsById(Long id) {
        Spu spu = spuMapper.selectByPrimaryKey(id);

        Sku sku = new Sku();
        sku.setSpuId(id);
        List<Sku> skuList = skuMapper.select(sku);
        Goods goods = new Goods();
        goods.setSpu(spu);
        goods.setSkuList(skuList);
        return goods;
    }



    /***
     * 添加商品信息
     * @param goods
     */


    @Override
    public void saveGoods(Goods goods) {
        Spu spu = goods.getSpu();

        //判断spuid是否为空
        if(spu.getId()==null) {
            // 为空则增加

//            Long id;
//            id = new Long((long)1234567);
//            spu.setId(id);

            entity.IdWorker idWorker = new entity.IdWorker(0,0);
            spu.setId(idWorker.nextId());

            spuMapper.insertSelective(spu);
        }else{
            //不为空则修改
            spuMapper.updateByPrimaryKeySelective(spu);

            Sku sku = new Sku();
            sku.setSpuId(spu.getId());
            skuMapper.delete(sku);
        }






        //List<sku>
        Date date = new Date();

        Category category = categoryMapper.selectByPrimaryKey(spu.getCategory3Id());
        Brand brand = brandMapper.selectByPrimaryKey(spu.getBrandId());

        List<Sku> skuList = goods.getSkuList();
        for(Sku sku : skuList) {

//            Long id;
//            id = new Long((long)1234567);
//            sku.setId(id);
            entity.IdWorker idWorker = new entity.IdWorker(0,0);
            sku.setId(idWorker.nextId());

            String name = spu.getName();

            if(StringUtils.isEmpty(sku.getSpec())) {
                sku.setSpec("{}");

            }

            Map<String,String> specMap = JSON.parseObject(sku.getSpec(), Map.class);
            for (Map.Entry<String,String> entry : specMap.entrySet()) {
                name+=" "+entry.getValue();
            }


            sku.setName(name);
            sku.setCreateTime(date);
            sku.setUpdateTime(date);
            sku.setSpuId(spu.getId());
            sku.setCategoryId(spu.getCategory3Id());
            sku.setCategoryName(category.getName());
            sku.setBrandName(brand.getName());
            skuMapper.insertSelective(sku);
        }


    }

}
