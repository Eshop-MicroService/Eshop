package com.eshop.goods.service.impl;

import com.eshop.goods.mapper.BrandMapper;
import com.eshop.goods.pojo.Brand;
import com.eshop.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
