package com.mycp.test;

import com.mycp.domain.Customer;
import com.mycp.utils.JpaUtils;
import org.hibernate.id.uuid.CustomVersionOneStrategy;
import org.junit.Test;
import sun.util.locale.StringTokenIterator;

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
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");

        // 2
//        EntityManager em = factory.createEntityManager();

        // 1-2
        EntityManager em = JpaUtils.getEntityManager();

        // 3
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 4
        Customer customer = new Customer();
        customer.setCustName("文刀2");
        customer.setCustIndustry("科技");

        em.persist(customer); // save

        // 5
        tx.commit();
        // 6
        em.close();
//        factory.close(); // 因为工厂是公共的，所以对此线程而言 不应关闭



    }


    /**
     * 根据id查询客户
     */
    @Test
    public void testFind() {
        // 1. 通过工具类获取实体类管理器
        EntityManager em = JpaUtils.getEntityManager();

        // 2. 开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 3. crud
        /**
         * 根据id查询数据
         *   参数：class实体类类型的字节码
         *         id 查询的主键的取值
         *
         *  使用find（）
         *      1. 查询的对象就是当前客户对象本身
         *      2. 在调用find方法时，就会发送sql语句查询数据库
         *
         *      立即加载
         *
         *
         *  注意：<property name="hibernate.hbm2ddl.auto" value="update"></property>
         */
        Customer customer = em.find(Customer.class, 1l);
        System.out.println(customer);

        // 4. 提交事务
        tx.commit();

        // 5. 释放资源
        em.close();

    }

    /**
     *  同样是查询，区别于find，
     *  getReference()
     *      1. 获取的对象是一个 动态代理对象
     *      2. 调用此方法时 不会立即发送sql语句查询数据库
     *              当真正要使用的时候，才发送sql查询
     *
     *      是延迟加载（懒加载）
     *      项目中常用此方法
     *
     */
    @Test
    public void testGetRef() {
        // 1-2
        EntityManager entityManager = JpaUtils.getEntityManager();

        // 3
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 4 crud
        // getReference()
        Customer customer = entityManager.getReference(Customer.class, 1l);
        System.out.println(customer);

        // 5
        tx.commit();

        // 6 free
        entityManager.close();

    }

    /**
     * 删除客户的案例
     */
    @Test
    public void testRemove() {
        // 1-2
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 3
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 4 crud
        // 根据id查询客户
        Customer customer = entityManager.find(Customer.class, 1l);

        // 调用remove
        entityManager.remove(customer);

        // 5
        tx.commit();

        // 6 free
        entityManager.close();

    }

    /**
     * 更新 merge(obj)
     */
    @Test
    public void testUpdate() {
        // 1-2
        EntityManager entityManager = JpaUtils.getEntityManager();
        // 3.
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 4. crud
        // find
        Customer customer = entityManager.find(Customer.class, 1l);
        // 更改
        customer.setCustIndustry("IT");
        entityManager.merge(customer);

        // 5.
        tx.commit();

        // 6. free
        entityManager.close();

    }


}
