package com.divoter.orderserver.service;

import com.divoter.form.OrderForm;
import com.divoter.orderserver.core.Service;
import com.divoter.orderserver.model.OrderMaster;

import java.util.Map;


/**
 * Created by divoter on 2020/09/15.
 */
public interface OrderMasterService extends Service<OrderMaster> {
    Map<String,Object> createOrder(OrderForm orderForm);
}
