package com.divoter.configserver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AutoRefreshController
 * @Description
 * @Authour Divoter
 * @Date 2020/9/17 9:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/refresh")
public class AutoRefreshController {
    @Resource
    private HttpServletRequest httpServletRequest;

    @PostMapping
    public void refresh(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
//        # 设置content_type为json要不然会报415的错误
        httpHeaders.add(HttpHeaders.CONTENT_TYPE,"application/json");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null,httpHeaders);
        String uri = httpServletRequest.getLocalAddr()+":"+httpServletRequest.getLocalPort();
        System.out.println("自动刷新转发uri:"+uri);
//        # 以post方法访问真正的刷新链接
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://"+uri+"/actuator/bus-refresh",
                request, String.class);

    }
}
