package com.divoter.productserver.service.impl;

import com.divoter.productserver.dao.ProductCategoryMapper;
import com.divoter.productserver.model.ProductCategory;
import com.divoter.productserver.service.ProductCategoryService;
import com.divoter.productserver.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class ProductCategoryServiceImpl extends AbstractService<ProductCategory> implements ProductCategoryService {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

}
