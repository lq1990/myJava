package com.mycp.consumeruser.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lq
 * create 2020-01-04 19:25
 */
@RestController
public class UserController {

    @Autowired // 注册进来
    RestTemplate restTemplate;

    /**
     * 发起buy请求时，会用restTemplate请求远程的PROVIDER-TICKET （provider名称，可指多个）
     *
     * @param name url中传递的参   xxx/buy?name=anna
     * @return
     */
    @GetMapping("/buy")
    public String buyTicket(String name) {
        String obj = restTemplate
                .getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name+"买了"+obj;
    }


}
