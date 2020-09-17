package com.divoter.productserver.controller;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.productserver.model.ProductCategory;
import com.divoter.productserver.service.ProductCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by divoter on 2020/09/15.
 */
@RestController
@RequestMapping("/api/v1/product/category")
public class ProductCategoryController {
    @Resource
    private ProductCategoryService productCategoryService;

    @PostMapping
    public Result add(@RequestBody ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        productCategoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ProductCategory productCategory) {
        productCategoryService.update(productCategory);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ProductCategory productCategory = productCategoryService.findById(id);
        return ResultGenerator.genSuccessResult(productCategory);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ProductCategory> list = productCategoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
