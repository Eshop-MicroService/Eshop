package com.eshop.goods.mapper;

import com.eshop.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

public interface BrandMapper extends Mapper<Brand> {

    @Select(value = "select tb.* from tb_brand tb ,tb_category_brand tbc where tb.id = tbc.brand_id and tbc.category_id=#{categoryid}")
    List<Brand> findByCategory(Integer categoryid);

}
