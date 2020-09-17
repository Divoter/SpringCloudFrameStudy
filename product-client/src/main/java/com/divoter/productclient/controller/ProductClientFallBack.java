package com.divoter.productclient.controller;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.constant.ResultCode;
import org.springframework.stereotype.Component;

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
    public Result feignListById(String invoke, Integer page, Integer size, List<String> productIdList) {
        return ResultGenerator.genFailResult(ResultCode.FAIL);
    }
}
