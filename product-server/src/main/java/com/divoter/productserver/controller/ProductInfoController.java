package com.divoter.productserver.controller;

import com.divoter.productserver.core.Result;
import com.divoter.productserver.core.ResultGenerator;
import com.divoter.productserver.model.ProductInfo;
import com.divoter.productserver.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by divoter on 2020/09/15.
*/
@RestController
@RequestMapping("/api/v1/product/info")
public class ProductInfoController {
    @Resource
    private ProductInfoService productInfoService;

    @PostMapping
    public Result add(@RequestBody ProductInfo productInfo) {
        productInfoService.save(productInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        productInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ProductInfo productInfo) {
        productInfoService.update(productInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ProductInfo productInfo = productInfoService.findById(id);
        return ResultGenerator.genSuccessResult(productInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ProductInfo> list = productInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
