package com.divoter.productserver.service;

import com.divoter.core.Result;
import com.divoter.productserver.core.Service;
import com.divoter.productserver.model.ProductInfo;

import java.util.Map;


/**
 * Created by divoter on 2020/09/15.
 */
public interface ProductInfoService extends Service<ProductInfo> {
    /**
     * 根据条件查询
     * @param searchMap 查询条件
     * @return
     */
    Result list(Map<String,Object> searchMap);
}
