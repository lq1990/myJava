package com.mycp.test;

import com.mycp.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 *
 *
 * @author lq
 * create 2019-11-28 14:15
 */
public class JpqlTest {

    /**
     * 查询全部:
     *  jpql: from com.mycp.domain.Customer
     *  sql: select * from cst_customer;
     */
    @Test
    public void testFindAll() {
        // 1
        EntityManager entityManager = JpaUtils.getEntityManager();

        // 2
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 3 crud
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql); // 创建query对象 query是真正执行jpql 的对象
        // 发送查询，并封装结果集
        List resultList = query.getResultList();
        for (Object obj : resultList) {
            System.out.println(obj);
        }

        // 4
        tx.commit();

        // 5
        entityManager.close();
    }

    /**
     * 根据id倒叙 查询全部
     * jpql: from Customer order by custId desc
     *
     */
    @Test
    public void testOrders() {
        // 1
        EntityManager entityManager = JpaUtils.getEntityManager();

        // 2
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 3 crud
        String jpql = "from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();

        for (Object obj : resultList) {
            System.out.println(obj);
        }

        // 4.
        tx.commit();

        // 5. free
        entityManager.close();

    }

    /**
     * 使用jpql查询，统计客户的总数
     *  sql: select count() from cst_customer;
     *  jpql不可以写select(*), : select count(custId) from Customer
     *
     */
    @Test
    public void testCount() {
        // 1.
        EntityManager em = JpaUtils.getEntityManager();
        // 2.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 3. crud
        String jpql = "select count(custId) from Customer";
        Query query = em.createQuery(jpql);

        Object result = query.getSingleResult();
        System.out.println(result);

        // 4
        tx.commit();
        // 5 free
        em.close();

    }

    /**
     * 分页查询：
     *  sql：select * from cst_customer limit ?,?;   // index0,num;
     *  jpql：from Customer
     */
    @Test
    public void testPaged() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // crud
        String jpql = "from Customer";
        Query query = em.createQuery(jpql);
        // 分页参数
        query.setFirstResult(0); // 起始索引
        query.setMaxResults(2); // 多少条

        List resultList = query.getResultList();

        for (Object obj : resultList) {
            System.out.println(obj);
        }

        //
        tx.commit();
        em.close();

    }

    /**
     * 条件查询
     *  案例：查询客户名称以“刀”开头的客户
     *  sql: select * from cst_customer where cust_name like '刀%';
     *  jpql: from Customer where custName like ?
     *
     *
     */
    @Test
    public void testCondition() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // crud
        String jpql = "from Customer where custName like ?";
        Query query = em.createQuery(jpql);

        query.setParameter(1, "刀%"); // index1(即从1开始计数的index), value

        List resultList = query.getResultList();
        for (Object obj : resultList) {
            System.out.println(obj);
        }

        //
        tx.commit();
        em.close();

    }

}
