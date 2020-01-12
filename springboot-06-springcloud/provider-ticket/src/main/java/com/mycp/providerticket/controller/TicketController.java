package com.mycp.providerticket.controller;


import com.mycp.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lq
 * create 2020-01-04 17:32
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;


    @GetMapping("/ticket")
    public String getTicket() {
        return ticketService.getTicket();
    }


}
