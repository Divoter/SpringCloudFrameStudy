package com.divoter.user.service;
import com.divoter.core.Result;
import com.divoter.user.model.UserInfo;
import com.divoter.user.core.Service;

import java.util.Map;


/**
 * Created by divoter on 2020/09/27.
 */
public interface UserInfoService extends Service<UserInfo> {
    /**
     * 方法反射调用
     * @param searchMap
     * @return
     */
    Result reflexMethodName(Map<String, Object> searchMap);
}
