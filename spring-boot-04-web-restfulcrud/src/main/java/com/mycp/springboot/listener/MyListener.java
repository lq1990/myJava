package com.mycp.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lq
 * create 2019-11-23 15:03
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener初始化，代表web应用启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener销毁，当关闭web应用后");
    }
}
