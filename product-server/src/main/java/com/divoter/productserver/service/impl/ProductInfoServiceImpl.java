package com.divoter.productserver.service.impl;

import com.divoter.productserver.dao.ProductInfoMapper;
import com.divoter.productserver.model.ProductInfo;
import com.divoter.productserver.service.ProductInfoService;
import com.divoter.productserver.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class ProductInfoServiceImpl extends AbstractService<ProductInfo> implements ProductInfoService {
    @Resource
    private ProductInfoMapper productInfoMapper;

}
