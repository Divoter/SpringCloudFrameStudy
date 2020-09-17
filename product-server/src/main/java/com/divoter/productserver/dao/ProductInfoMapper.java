package com.divoter.productserver.dao;

import com.divoter.productserver.core.Mapper;
import com.divoter.productserver.model.ProductInfo;

import java.util.List;
import java.util.Map;

public interface ProductInfoMapper extends Mapper<ProductInfo> {
    List<Map<String,Object>> findByAllConfition(Map<String,Object> map);

}