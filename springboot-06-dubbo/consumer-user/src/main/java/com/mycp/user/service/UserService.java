package com.mycp.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mycp.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * create 2020-01-04 14:21
 */
@Service // Spring的service
public class UserService {

    /**
     * 注解@Reference 远程引用.
     * 因为TicketService在Ticket模块中已经发布了，所以可以获取
     */
    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("我是user，买到票了" + ticket);

    }

}
