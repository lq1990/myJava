package com.mycp.redis123;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import sun.applet.Main;

/**
 * @author lq
 * create 2019-12-26 18:29
 */
public class Demo1 {


    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.230.131", 6379);

        jedis.set("", "");

    }

}
