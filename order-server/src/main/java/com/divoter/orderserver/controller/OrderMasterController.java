package com.divoter.orderserver.controller;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.model.OrderMaster;
import com.divoter.orderserver.service.OrderMasterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by divoter on 2020/09/14.
*/
@RestController
@RequestMapping("/api/v1/order/master")
public class OrderMasterController {
    @Resource
    private OrderMasterService orderMasterService;

    @PostMapping
    public Result add(@RequestBody OrderMaster orderMaster) {
        orderMasterService.save(orderMaster);
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
