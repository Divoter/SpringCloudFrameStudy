package com.divoter.orderserver.service.impl;

import com.divoter.core.AbstractService;
import com.divoter.core.model.OrderMaster;
import com.divoter.orderserver.dao.OrderMasterMapper;
import com.divoter.orderserver.service.OrderMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by divoter on 2020/09/14.
 */
@Service
@Transactional
public class OrderMasterServiceImpl extends AbstractService<OrderMaster> implements OrderMasterService {

    private  final Logger logger = LoggerFactory.getLogger(OrderMasterServiceImpl.class);

    @Resource
    private OrderMasterMapper orderMasterMapper;

}
