package com.mycp.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * create 2020-01-03 12:00
 */
@Service
public class ScheduledService {

    /**
     * cron: second  秒
     *       minute  分
     *       hour  小时
     *       day of month  日期
     *       month  月份
     *       day of week  星期，0-7   SUN-SAT.   0 7都是SUN
     *
     *
     *       0 * * * * MON-FRI 代表周一到周五每分钟的0秒启动
     *
     */
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI") 枚举
//    @Scheduled(cron = "0-4 * * * * MON-FRI")  - 范围
    @Scheduled(cron = "0/4 * * * * MON-FRI")  // 每4秒
    public void hello() {
        System.out.println("hello...");
    }



}
