package com.mycp.test;

import com.mycp.dao.CustomerDao;
import com.mycp.dao.LinkManDao;
import com.mycp.domain.Customer;
import com.mycp.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * 对象导航查询
 *  查询一个对象的同时，通过此对象 查询它的关联对象
 *
 * @author lq
 * create 2019-12-15 17:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectQueryTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    /**
     * 测试 对象导航查询
     *
     */
    @Test
    @Transactional // 解决 no Session 的问题
    public void testQuery1() {

        // 查询客户
        Customer one = customerDao.getOne(1L);

        // 对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkMans = one.getLinkMans();
        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }

    }


    /**
     * 对象导航查询：
     *  默认使用的是延迟加载的形式查询的
     *      调用get方法并不会立即发送查询，而是在使用关联对象时才会查
     *
     *  修改配置：将延迟加载改为立即加载
     *      fetch, 需要配置到多表映射关系的注解上
     *
     */
    @Test
    @Transactional
    public void testQuery2() {

        Customer one = customerDao.findOne(1l); // 使用立即加载的方式 查询

        Set<LinkMan> linkMans = one.getLinkMans();
//        for (LinkMan linkMan : linkMans) {
//            System.out.println(linkMan);
//        }

        System.out.println(linkMans.size());

    }


    /**
     * 从联系人对象 导航查询它的所属客户
     *
     */
    @Test
    @Transactional // 解决在java代码中的no session问题
    public void testQuery3() {
        LinkMan one = linkManDao.findOne(2L); // 通过 left outer join 把客户和联系人都查询了

        // 对象导航查询 所属的客户
        Customer customer = one.getCustomer();
        System.out.println(customer);

    }


}
