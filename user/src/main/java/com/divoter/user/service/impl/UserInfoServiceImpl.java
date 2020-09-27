package com.divoter.user.service.impl;

import com.divoter.core.Result;
import com.divoter.core.ResultGenerator;
import com.divoter.core.constant.ResultCode;
import com.divoter.user.core.AbstractService;
import com.divoter.user.dao.UserInfoMapper;
import com.divoter.user.model.UserInfo;
import com.divoter.user.service.UserInfoService;
import com.divoter.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * Created by divoter on 2020/09/27.
 */
@Service
@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public Result reflexMethodName(Map<String, Object> map) {
        try{
            if(CommonUtil.isBlank(map.get("methodName"))){
                return ResultGenerator.genFailResult(ResultCode.FAIL);
            }
            Method methodName = this.getClass().getDeclaredMethod(map.get("methodName").toString(), Map.class);
            return (Result) methodName.invoke(this,map);
        }catch (Exception e){
            return ResultGenerator.genFailResult(ResultCode.FAIL);
        }
    }

    protected Result login(Map<String,Object> map){
        Condition condition = new Condition(UserInfo.class);
        condition.createCriteria().andEqualTo("username",map.get("username")).andEqualTo("password",map.get("password"));
        List<UserInfo> list = findByCondition(condition);
        if(CommonUtil.isNotBlank(list)&&!list.isEmpty()){
            list.get(0).setPassword("");
            return ResultGenerator.genSuccessResult(list.get(0));
        }
        return ResultGenerator.genFailResult(ResultCode.LOGIN_FAIL);
    }
}
