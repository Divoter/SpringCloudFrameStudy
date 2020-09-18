package com.divoter.orderserver.client;

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
    public Result feignListById(@RequestParam Integer page, @RequestParam Integer size
            , @RequestParam String mnflg, @RequestParam String id , @RequestParam String name
            , @RequestParam Integer status , @RequestParam String categoryName
            , @RequestParam List<String> ids) {
        return ResultGenerator.genFailResult(ResultCode.FAIL);
    }
}
