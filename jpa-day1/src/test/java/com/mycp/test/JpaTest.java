package com.mycp.test;

import com.mycp.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 测试jpa的保存
 *  保存一个客户到db中
 *
 * @author lq
 * create 2019-11-27 20:50
 */
public class JpaTest {

    /**
     * 测试jpa的保存
     * 保存一个客户到db中
     *
     * 步骤:
     *  1. 加载配置文件 创建工厂（实体管理类工厂）对象
     *  2. 通过 实体管理类工厂 获取实体管理器
     *  3. 获取事务对象，开启事务
     *  4. CRUD操作
     *  5. 提交事务（回滚事务）
     *  6. 释放资源
     *
     */
    @Test
    public void testSave() {
        // 1
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        // 2
        EntityManager em = factory.createEntityManager();
        // 3
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 4
        Customer customer = new Customer();
        customer.setCustName("文刀");
        customer.setCustIndustry("科技");

        em.persist(customer); // save

        // 5
        tx.commit();
        // 6
        em.close();
        factory.close();



    }


}
