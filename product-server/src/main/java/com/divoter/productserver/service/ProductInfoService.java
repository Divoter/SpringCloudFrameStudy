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
     * 方法反射调用
     * @param searchMap
     * @return
     */
    Result reflexMethodName(Map<String, Object> searchMap);
}
