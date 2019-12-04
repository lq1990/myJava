package com.mycp.test;

import com.mycp.dao.CustomerDao;
import com.mycp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author lq
 * create 2019-12-02 21:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindJPQL() {
        Customer customer = customerDao.findJpql("文刀2");
        System.out.println(customer);

    }

    /**
     * 案例：根据客户名称 和 客户id查询客户
     *  jpql：from Customer where custName=? and custId=?
     *
     *
     *  jpql中没有select *
     *
     *
     */
    @Test
    public void testFindCustNameAndId() {

        Customer customer = customerDao.findCustNameAndId(2l, "刀刀");
        System.out.println(customer);
    }


    /**
     *  使用jpql完成 update/delete操作，
     *  1. 需要手动添加事务的支持
     *  2. 默认执行结束之后，回滚事务。所以若只写 customerDao.updateCustomer(4l, "黑马就是好")， 则db中并不会真的更新数据
     *
     *  使用注解Rollback设置是否自动回滚
     *
     *
     *
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdate() {
        customerDao.updateCustomer(4l, "黑马就是好");

    }

    /**
     * 测试sql查询
     *
     */
    @Test
    public void testFindSql() {
//        List<Object[]> list = customerDao.findSql();
        List<Object[]> list = customerDao.findSql("刀%");

        for (Object[] obj : list) { // obj是 数组
            System.out.println(Arrays.toString(obj));
        }

    }

    @Test
    public void testFindCustName() {
        Customer customer = customerDao.findByCustName("刀刀");
        System.out.println(customer);
    }

    @Test
    public void testFindLike() {
        List<Customer> customers = customerDao.findByCustNameLike("刀%");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testFindLikeLike() {
        List<Customer> customers = customerDao.findByCustNameLikeAndCustIndustryLike("刀%", "科%");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }


}
