package com.divoter.orderserver.service.impl;

import com.divoter.orderserver.dao.OrderDetailMapper;
import com.divoter.orderserver.model.OrderDetail;
import com.divoter.orderserver.service.OrderDetailService;
import com.divoter.orderserver.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class OrderDetailServiceImpl extends AbstractService<OrderDetail> implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;

}
