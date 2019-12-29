package com.mycp.amqp.service;

import com.mycp.amqp.book.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * create 2019-12-28 21:04
 */
@Service
public class BookService {

    /**
     * 监听某个队列，只要该队列中有新内容进来，就会执行此方法
     *
     * @param book
     */
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("atguigu.news队列有更新，收到消息"+book);

    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message) {

        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());

    }


}
