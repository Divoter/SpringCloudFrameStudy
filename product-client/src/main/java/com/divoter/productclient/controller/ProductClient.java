package com.divoter.productclient.controller;

import com.divoter.core.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Description
 * @Authour Divoter
 * @Date 2020/9/17 13:21
 * @Version 1.0
 */
@FeignClient(name = "productserver", fallback = ProductClientFallBack.class)
@RequestMapping("/api/v1/product/info")
public interface ProductClient {
    @GetMapping
    public Result feignListById(String invoke, Integer page, Integer size, List<String> productIdList);
}
