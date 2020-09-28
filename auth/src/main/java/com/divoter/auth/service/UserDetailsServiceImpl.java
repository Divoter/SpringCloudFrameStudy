package com.divoter.auth.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName UserDetailsServiceImpl
 * @Description 实现校验功能
 * @Authour Divoter
 * @Date 2020/9/28 16:40
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //数据库查询用户信息
//        Model model = new Model();
        String password = "";
        //创建权限验证对象
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        //查询权限
        List<Map<String,Object>> permissions = Lists.newArrayList();
        permissions.add(new HashMap<String,Object>(){
            {
                put("name","sysAdmin");
            }
        });
        permissions.forEach(stringObjectMap -> {
            GrantedAuthority grantedAuthority= new SimpleGrantedAuthority(stringObjectMap.get("name").toString());
            grantedAuthorities.add(grantedAuthority);
        });
        return new User(username,password,grantedAuthorities);
    }
}
