package com.mycp.providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @author lq
 * create 2020-01-04 17:30
 */
@Service
public class TicketService {


    public String getTicket() {
        System.out.println("8003. TicketService.getTicket()");
        return "《厉害了》";
    }


}
