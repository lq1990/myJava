package com.mycp.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.List;
import java.util.Random;

/**
 * @author lq
 * create 2020-01-08 10:41
 */
public class RandomRule_LQ extends AbstractLoadBalancerRule {

    private int totalInvokeCount = 0; // 总共被调用的次数，目前要求每台被调用5次
    private int currentServerIndex = 0; // 当前提供服务的机器号


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.choose(getLoadBalancer(), key);
    }

    /**
     * Randomly choose from all living servers
     *
     * @param lb
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        Server server = null;

        // 多线程环境下，使用while，等线程苏醒后，还可以拉回来重新判断一次
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size(); // 实例数目
            if (serverCount == 0) {
                return null;
            }

//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);


            // 新的需求，每个server被调用5次后，换server，轮询.
            // 注：整个while循环内，每次调用都是从循环体头到尾一次
            if (totalInvokeCount < 5) {
                // 当调用次数小于5，是依旧是当前server服务
                server = upList.get(currentServerIndex);
                totalInvokeCount++;

            } else {
                // 当调用此数>=5时，重置total，换index

                totalInvokeCount = 0;
                currentServerIndex++;

                if (currentServerIndex >= upList.size()) {
                    currentServerIndex = 0;
                }

            }


            if (server == null){
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();

        }

        return server;

    }

}
