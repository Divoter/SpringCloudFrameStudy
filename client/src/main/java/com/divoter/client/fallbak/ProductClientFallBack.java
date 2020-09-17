package com.divoter.client.fallbak;

import com.divoter.client.ProductClient;
import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.constant.ResultCode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName ProductClientFallBack
 * @Description
 * @Authour Divoter
 * @Date 2020/9/17 13:21
 * @Version 1.0
 */
@Component
public class ProductClientFallBack implements ProductClient {
    @Override
//    public Result feignListById(String mnflg, Integer page, Integer size, List<String> productIdList) {
    public Result feignListById(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size
            , String mnflg, @RequestParam(required = false) String id , @RequestParam(required = false) String name
            , @RequestParam(required = false) Integer status , @RequestParam(required = false) String categoryName
            , @RequestParam(required = false) List<String> idst) {
        return ResultGenerator.genFailResult(ResultCode.FAIL);
    }
}
