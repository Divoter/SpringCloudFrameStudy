package com.divoter.productserver.service.impl;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.constant.ResultCode;
import com.divoter.productserver.core.AbstractService;
import com.divoter.productserver.dao.ProductInfoMapper;
import com.divoter.productserver.model.ProductInfo;
import com.divoter.productserver.service.ProductInfoService;
import com.divoter.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class ProductInfoServiceImpl extends AbstractService<ProductInfo> implements ProductInfoService {
    @Resource
    private ProductInfoMapper productInfoMapper;

    /**
     * controller采用restful规范，
     * 因此具体的方法实现通过反射去调用
     * 此为查询方法
     * @param searchMap 查询条件
     * @return
     */
    @Override
    public Result list(Map<String, Object> searchMap) {
        try{
            if(CommonUtil.isBlank(searchMap.get("methodName"))){
                return ResultGenerator.genFailResult(ResultCode.FAIL);
            }
            Method methodName = this.getClass().getDeclaredMethod(searchMap.get("methodName").toString(), Map.class);
            return (Result) methodName.invoke(this,searchMap);
        }catch (Exception e){
            return ResultGenerator.genFailResult(ResultCode.FAIL);
        }
    }

    /**
     * <p>远程调用</p>
     * 根据商品id（list）查询商品信息
     * @param searchMap
     * @return
     */
    protected Result feignListById(Map<String,Object> searchMap){
        searchMap.put("status",0);
        return findList(searchMap);
    }

    /**
     * 查询所有上架商品
     * @return
     */
    protected Result findUpAll(Map<String,Object> searchMap){
        searchMap.put("status",0);
        return  findList(searchMap);
    }

    /**
     * 查询商品
     * @param searchMap
     * @return
     */
    private Result findList(Map<String,Object> searchMap){
        int page = Integer.parseInt(searchMap.get("page").toString());
        int size = Integer.parseInt(searchMap.get("size").toString());
        PageHelper.startPage(page,size);
        List<Map<String,Object>> list = productInfoMapper.findByAllConfition(searchMap);;
        PageInfo pageInfo = new PageInfo(list);
        return  ResultGenerator.genSuccessResult(pageInfo);
    }
}
