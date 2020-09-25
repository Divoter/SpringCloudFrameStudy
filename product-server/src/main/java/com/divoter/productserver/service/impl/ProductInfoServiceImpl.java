package com.divoter.productserver.service.impl;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.constant.ResultCode;
import com.divoter.productserver.core.AbstractService;
import com.divoter.productserver.dao.ProductInfoMapper;
import com.divoter.productserver.model.ProductInfo;
import com.divoter.productserver.service.ProductInfoService;
import com.divoter.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class ProductInfoServiceImpl extends AbstractService<ProductInfo> implements ProductInfoService {
    @Resource
    private ProductInfoMapper productInfoMapper;
    @Resource
    private AmqpTemplate amqpTemplate;

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
        int page = CommonUtil.isBlank(searchMap.get("page"))?0:Integer.parseInt(searchMap.get("page").toString());
        int size = CommonUtil.isBlank(searchMap.get("size"))?0:Integer.parseInt(searchMap.get("size").toString());
        PageHelper.startPage(page,size);
        List<Map<String,Object>> list = productInfoMapper.findByAllConfition(searchMap);;
        PageInfo pageInfo = new PageInfo(list);
        return  ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 扣库存
     * @param updateMap
     * @return
     */
    protected Result deductStock(Map<String,Object> updateMap){
        List<ProductInfo> productlist = (List<ProductInfo>) updateMap.get("list");
        if(CommonUtil.isBlank(updateMap.get("ids"))){
            if(null!=productlist && !productlist.isEmpty()){
                updateMap.put("ids",productlist
                        .stream()
                        .map(p->p.getProductId())
                        .collect(Collectors.toList()));
            }else{
                // 发送mq消息
                amqpTemplate.convertAndSend("productInfo", "扣库存失败！");
                return ResultGenerator.genFailResult(ResultCode.REQ_PARAM_ERR);
            }
        }
        //先查询库存是否足够
        Result findResult = feignListById(updateMap);
        List<String> errList = new ArrayList<>();
        if(findResult.isSuccess() && ResultCode.SUCCESS.getCode().equals(findResult.getCode())){
            //扣除库存
            for (int i = 0; i < productlist.size(); i++) {
                ProductInfo upProductInfo = productlist.get(i);
                for (Object obj: ((PageInfo)findResult.getData()).getList()  ) {
                    Map<String,Object> productInfo = (Map<String, Object>) obj;
                    if(upProductInfo.getProductId().equals(productInfo.get("productId"))){//同一产品
                        if(Integer.valueOf(productInfo.get("productStock").toString()).compareTo(upProductInfo.getProductStock())>=0){//库存足够
                            Integer num = Integer.valueOf(productInfo.get("productStock").toString()) - upProductInfo.getProductStock();
                            productInfo.put("productStock",num);
                            upProductInfo.setProductStock(num);
                            update(upProductInfo);
                        }else{
                            errList.add(productInfo.get("productName").toString());
                        }
                        break;
                    }
                }
            }
        }
        String message = "";
        try {
            message = new ObjectMapper().writeValueAsString(productlist);
        } catch (JsonProcessingException e) {
        }
        // 发送mq消息
        amqpTemplate.convertAndSend("productInfo", message);
        if(!errList.isEmpty()){
            return ResultGenerator.genSuccessResult(errList.toString(),productlist);
        }
        return  ResultGenerator.genSuccessResult(productlist);
    }
}
