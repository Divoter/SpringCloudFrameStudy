package com.divoter.orderserver.service.impl;

import com.divoter.orderserver.dao.OrderMasterMapper;
import com.divoter.core.model.OrderMaster;
import com.divoter.orderserver.service.OrderMasterService;
import com.divoter.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by divoter on 2020/09/14.
 */
@Service
@Transactional
public class OrderMasterServiceImpl extends AbstractService<OrderMaster> implements OrderMasterService {
    @Resource
    private OrderMasterMapper orderMasterMapper;

}
