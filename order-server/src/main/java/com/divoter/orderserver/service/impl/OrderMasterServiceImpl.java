package com.divoter.orderserver.service.impl;

import com.divoter.orderserver.dao.OrderMasterMapper;
import com.divoter.orderserver.model.OrderMaster;
import com.divoter.orderserver.service.OrderMasterService;
import com.divoter.orderserver.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by divoter on 2020/09/15.
 */
@Service
@Transactional
public class OrderMasterServiceImpl extends AbstractService<OrderMaster> implements OrderMasterService {
    @Resource
    private OrderMasterMapper orderMasterMapper;

}
