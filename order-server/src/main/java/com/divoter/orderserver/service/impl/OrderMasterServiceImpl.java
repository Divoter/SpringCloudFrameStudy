package com.divoter.orderserver.service.impl;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.constant.OrderStatusEnum;
import com.divoter.core.constant.PayStatusEnum;
import com.divoter.core.constant.ResultCode;
import com.divoter.form.OrderForm;
import com.divoter.orderserver.client.ProductClient;
import com.divoter.orderserver.core.AbstractService;
import com.divoter.orderserver.dao.OrderMasterMapper;
import com.divoter.orderserver.model.OrderDetail;
import com.divoter.orderserver.model.OrderMaster;
import com.divoter.orderserver.service.OrderDetailService;
import com.divoter.orderserver.service.OrderMasterService;
import com.divoter.util.KeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class OrderMasterServiceImpl extends AbstractService<OrderMaster> implements OrderMasterService {
    private static final Logger logger = LoggerFactory.getLogger(OrderMasterServiceImpl.class);
    @Resource
    private OrderMasterMapper orderMasterMapper;
    @Resource
    private OrderDetailService orderDetailService;

    @Resource
    private ProductClient productClient;

    @Override
    public Result createOrder(OrderMaster orderMaster) {
        String orderId = KeyUtil.genUniqueKey("order");
        //1.查询商品信息(调用商品服务)
        List<String > list = (List<String>) orderMaster.getItems().stream().map((p)->{
            return p.getProductId();
        }).collect(Collectors.toList());
        Result productResult = productClient.feignListById(0,0,"feignListById",null,null,null,null,list);
        if(!productResult.isSuccess()|| !ResultCode.SUCCESS.getCode().equals(productResult.getCode())){
            return productResult;
        }
        LinkedHashMap<String,Object> result = (LinkedHashMap<String, Object>) productResult.getData();
        List<Map<String,Object>> productList = (List<Map<String, Object>>) result.get("list");

        //2.计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail :orderMaster.getItems()) {
            for (Map<String,Object> productInfo: productList) {
                //TODO 注意 前面回去的是object  后面是Bigdecimal  比较的时候要注意
//                if (productInfo.get("productPrice").equals(orderDetail.getProductPrice())) {
                    //单价*数量
                    orderAmout = new BigDecimal(productInfo.get("productPrice").toString())
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
//                    orderDetailRepository.save(orderDetail);
                    orderDetailService.save(orderDetail);
//                }
            }
        }

        //3.扣库存(调用商品服务)

        //4.订单入库
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setBuyerName("test");
        orderMaster.setBuyerAddress("test");
        orderMaster.setBuyerPhone("17112345678");
        orderMaster.setBuyerOpenid("uuid");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        save(orderMaster);
        return ResultGenerator.genSuccessResult(orderMaster);
    }
}
