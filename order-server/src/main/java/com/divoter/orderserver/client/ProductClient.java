package com.divoter.orderserver.client;

import com.divoter.core.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
public interface ProductClient {
    @GetMapping("/api/v1/product/info")
    Result feignListById(@RequestParam Integer page, @RequestParam Integer size
            , @RequestParam String mnflg, @RequestParam String id , @RequestParam String name
            , @RequestParam Integer status , @RequestParam String categoryName
            , @RequestParam List<String> ids);
}
