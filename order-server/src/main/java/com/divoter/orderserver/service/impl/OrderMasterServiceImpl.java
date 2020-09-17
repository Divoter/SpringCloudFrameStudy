package com.divoter.orderserver.service.impl;

import com.divoter.form.OrderForm;
import com.divoter.orderserver.core.AbstractService;
import com.divoter.orderserver.dao.OrderMasterMapper;
import com.divoter.orderserver.model.OrderDetail;
import com.divoter.orderserver.model.OrderMaster;
import com.divoter.orderserver.service.OrderMasterService;
import com.divoter.util.KeyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class OrderMasterServiceImpl extends AbstractService<OrderMaster> implements OrderMasterService {
    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Override
    public Map<String, Object> createOrder(OrderForm orderForm) {
        String orderId = KeyUtil.genUniqueKey("order");
        List<String > list = (List<String>) orderForm.getItems().stream().map((p)->{
            OrderDetail orderDetail = (OrderDetail) p;
            return orderDetail.getProductId();
        }).collect(Collectors.toList());
        return null;
    }
}
