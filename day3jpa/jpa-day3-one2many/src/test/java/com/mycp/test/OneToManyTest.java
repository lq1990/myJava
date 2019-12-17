package com.mycp.test;

import com.mycp.dao.CustomerDao;
import com.mycp.dao.LinkManDao;
import com.mycp.domain.Customer;
import com.mycp.domain.LinkMan;
import com.oracle.deploy.update.UpdateCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

/**
 * @author lq
 * create 2019-12-14 23:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {


    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;


    /**
     * 保存一个客户，保存一个联系人
     *
     */
    @Test
    @Transactional // 为了保持事务的一致性
    @Rollback(false) // 不自动回滚
    public void testAdd() {
        // 创建一个客户，创建一个联系人
        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李");

        /**
         * 配置了客户到联系人的关系
         *  从客户的角度上，发送两条insert语句，发送一条更新语句更新db（更新外键）
         *
         * 由于我们配置了客户到联系人的关系，客户可以对外键进行维护
         *
         */
        customer.getLinkMans().add(linkMan); // 在实体类中配置关系

        customerDao.save(customer);
        linkManDao.save(linkMan);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd1() {
        Customer customer = new Customer();
        customer.setCustName("百度2");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李2");


        /**
         * 配置联系人到客户的关系（多对一）
         *  只发送两条insert语句
         * 由于配置了联系人到客户的映射关系（多对一）
         */
        linkMan.setCustomer(customer);


        customerDao.save(customer);
        linkManDao.save(linkMan);

    }

    /**
     * 双向关系 都建立的测试
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testAdd2() {
        Customer customer = new Customer();
        customer.setCustName("百度3");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李3");


        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan); // 多余的，可不写。当在主表中配置了 @OneToMany(mappedBy = "customer")后会使得主表放弃对外键的维护权


        customerDao.save(customer);
        linkManDao.save(linkMan);

    }


    /**
     * 级联添加: 保存一个客户的同时，保存客户的所有联系人
     *
     *  需要在操作主体的实体类上，配置cascade属性
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("百度4");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李4");


        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);

        customerDao.save(customer);

    }

    /**
     * 级联删除:
     *  删除1号客户的同时，删除1号客户的所有联系人
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeRemove() {

        // 查询1号客户
        Customer one = customerDao.findOne(1l);

        // remove
        customerDao.delete(one);

}



}
