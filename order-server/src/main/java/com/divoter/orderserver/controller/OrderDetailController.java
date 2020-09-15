package com.divoter.orderserver.controller;

import com.divoter.orderserver.core.Result;
import com.divoter.orderserver.core.ResultGenerator;
import com.divoter.orderserver.model.OrderDetail;
import com.divoter.orderserver.service.OrderDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by divoter on 2020/09/15.
*/
@RestController
@RequestMapping("/api/v1/order/detail")
public class OrderDetailController {
    @Resource
    private OrderDetailService orderDetailService;

    @PostMapping
    public Result add(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        orderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OrderDetail orderDetail) {
        orderDetailService.update(orderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        OrderDetail orderDetail = orderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(orderDetail);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OrderDetail> list = orderDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
