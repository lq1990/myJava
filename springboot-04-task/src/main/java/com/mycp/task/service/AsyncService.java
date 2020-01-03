package com.mycp.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务使用的挺多，比如邮件
 *
 *
 * @author lq
 * create 2020-01-03 11:40
 */
@Service
public class AsyncService {

    /**
     *  标注 @Async 注解
     *  告诉spring，这是异步方法。spring会自动开一个线程池进行调用
     */
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理中。。。");
    }


}
