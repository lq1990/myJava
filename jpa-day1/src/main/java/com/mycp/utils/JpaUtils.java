package com.mycp.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 解决实体管理器工厂的 浪费资源 耗时问题
 *  通过静态代码块的形式，当程序第一次访问此工具类时，创建一个公共的实体管理器工厂对象
 *
 *
 *
 * @author lq
 * create 2019-11-28 11:33
 */
public class JpaUtils {
    private static EntityManagerFactory factory;

    static {
        // 1. 加载配置文件，创建 EntityManagerFactory. 创建工厂是线程安全的。
        factory = Persistence.createEntityManagerFactory("myJpa");

    }

    /**
     * 获取EntityManager对象
     */
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
