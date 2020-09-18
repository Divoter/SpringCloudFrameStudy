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

    @Override
    public Result reflexMethodName(Map<String, Object> Map){
        try{
            if(CommonUtil.isBlank(Map.get("methodName"))){
                return ResultGenerator.genFailResult(ResultCode.FAIL);
            }
            Method methodName = this.getClass().getDeclaredMethod(Map.get("methodName").toString(), Map.class);
            return (Result) methodName.invoke(this,Map);
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

    private Result deductStock(Map<String,Object> updateMap){
        List<ProductInfo> productlist = (List<ProductInfo>) updateMap.get("list");
        //先查询库存是否足够

        //扣除库存

        return  ResultGenerator.genSuccessResult(productlist);
    }
}
