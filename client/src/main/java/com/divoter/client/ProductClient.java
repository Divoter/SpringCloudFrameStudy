package com.divoter.client;

import com.divoter.client.fallbak.ProductClientFallBack;
import com.divoter.core.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Description
 * @Authour Divoter
 * @Date 2020/9/17 13:21
 * @Version 1.0
 */
@FeignClient(name = "PRODUCTSERVER", fallback = ProductClientFallBack.class)
@RequestMapping("/api/v1/product/info")
public interface ProductClient {
    @GetMapping
//    public Result feignListById(String mnflg, Integer page, Integer size, List<String> ids);
    public Result feignListById(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size
            , String mnflg, @RequestParam(required = false) String id , @RequestParam(required = false) String name
            , @RequestParam(required = false) Integer status , @RequestParam(required = false) String categoryName
            , @RequestParam(required = false) List<String> ids);
}
