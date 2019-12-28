package com.mycp.amqp;

import com.mycp.amqp.book.Book;
import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.HashCodeAndEqualsMockWrapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot02AmqpApplicationTests {

    /**
     * 用于给RabbitMQ 发送和接收消息
     */
    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * 1. 单播（点对点）
     */
    @Test
    void contextLoads() {

//          msg: 可以自己构造一个；定义消息体内容和消息头
//        rabbitTemplate.send(exchange, routingKey, msg);

        /**
         * 只需要传入要发送的对象，自动序列化发送给rabbitmq.
         * object默认当成消息体
         */
//        rabbitTemplate.convertAndSend(exchange, routingKey, object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));

        // 对象被默认序列化后发送出去
        rabbitTemplate.convertAndSend(
                "exchange.direct",
                "atguigu",
                new Book("西游记2","吴承恩2"));


        // 如何将数据自动的转为json格式，发到消息队列



    }

    /**
     * 接收消息。
     * 从消息队列里拿到消息后，原队列中会去除此消息。
     *
     *
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);

    }


    // =====================================================
    // =====================================================
    // =====================================================

    /**
     * 广播.
     * 不必指定routingKey, 因为所有的队列都会收到消息
     *
     */
    @Test
    public void sendMsg() {

         rabbitTemplate.convertAndSend(
                 "exchange.fanout",
                 "",
                 new Book("红楼梦", "曹雪芹"));

     }

     // 提前在 web界面中，指定exchanges queues，在java代码中写明exchange即可。



}
