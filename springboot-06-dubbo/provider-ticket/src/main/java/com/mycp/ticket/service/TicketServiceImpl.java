package com.mycp.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author lq
 * create 2020-01-04 14:17
 */
@Component // 将服务加入到spring容器中
@Service // 注意是dubbo的Service，将服务发布出去。这样发布之后，其它module可以引用
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "《厉害了》";
    }

}

