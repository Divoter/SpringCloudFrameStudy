package com.divoter.user.controller;


import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.user.model.UserInfo;
import com.divoter.user.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by divoter on 2020/09/27.
*/
@RestController
@RequestMapping("/api/v1/user/info")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @PostMapping
    public Result add(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody UserInfo userInfo) {
        userInfoService.update(userInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        UserInfo userInfo = userInfoService.findById(id);
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size
            ,@RequestParam String mnFlg,@RequestParam(required = false) String username, @RequestParam(required = false) String password
                       ) {
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("size",size);
        map.put("methodName",mnFlg);
        map.put("username",username);
        map.put("password",password);
        return userInfoService.reflexMethodName(map);
    }
}
