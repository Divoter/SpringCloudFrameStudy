package com.divoter.orderserver.controller;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.form.OrderForm;
import com.divoter.orderserver.model.OrderMaster;
import com.divoter.orderserver.service.OrderMasterService;
import com.divoter.util.ErrorUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
* Created by divoter on 2020/09/15.
*/
@RestController
@RequestMapping("/api/v1/order/master")
public class OrderMasterController {

    private final static Logger logger = LoggerFactory.getLogger(OrderMasterController.class);

    @Resource
    private OrderMasterService orderMasterService;

    @PostMapping
    public Result add(@RequestBody @Valid OrderForm orderForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultGenerator.genParamErrorResult(
                    ErrorUtil.getAllErrorMessages(bindingResult.getAllErrors())
            );
        }
//        orderMasterService.save(orderMaster);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        orderMasterService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OrderMaster orderMaster) {
        orderMasterService.update(orderMaster);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        OrderMaster orderMaster = orderMasterService.findById(id);
        return ResultGenerator.genSuccessResult(orderMaster);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OrderMaster> list = orderMasterService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
