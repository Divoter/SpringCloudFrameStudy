package com.divoter.productserver.controller;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.productserver.model.ProductInfo;
import com.divoter.productserver.service.ProductInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size
            , String mnflg,@RequestParam(required = false) String id , @RequestParam(required = false) String name
            , @RequestParam(required = false) Integer status , @RequestParam(required = false) String categoryName
            , @RequestParam(required = false) List<String> ids
    ) {
       Map<String,Object> map = new HashMap<>();
       map.put("page",page);
       map.put("size",size);
       map.put("methodName",mnflg);
       map.put("id",id);
       map.put("name",name);
       map.put("id",status);
       map.put("categoryName",categoryName);
       map.put("ids",ids);
       return productInfoService.list(map);
    }
}
