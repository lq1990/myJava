package com.mycp.test;

import com.mycp.dao.CustomerDao;
import com.mycp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 单元测试里需要指定是在spring的单元测试环境下
 *
 *
 * @author lq
 * create 2019-11-29 18:25
 */
@RunWith(SpringJUnit4ClassRunner.class) // 声明spring提供的单元测试环境
@ContextConfiguration("classpath:applicationContext.xml") // 指定spirng容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询一个
     *
     */
    @Test
    public void testFindOne() {
        Customer one = customerDao.findOne(3L);
        System.out.println(one);
    }

    /**
     * save：保存或者更新
     *  根据传递的对象是否存在主键id，
     *      若没有id主键属性，则保存。
     *      若有id主键属性，根据id查询数据，更新数据
     *
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        // 没有set主键，是增
        customer.setCustName("黑马");
        customer.setCustLevel("vip");
        customer.setCustIndustry("it edu");

        customerDao.save(customer);
    }


    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setCustId(4l); // 当设置主键时，为update
        customer.setCustName("黑马2");
        // 注意：其它没有set的属性 都为null


        customerDao.save(customer);

    }

    /**
     * 删除。
     *  delete(主键)
     */
    @Test
    public void testDelete() {

        customerDao.delete(3l);

//        Hibernate: select customer0_.cust_id as cust_id1_0_0_, customer0_.cust_address as cust_add2_0_0_, customer0_.cust_industry as cust_ind3_0_0_, customer0_.cust_level as cust_lev4_0_0_, customer0_.cust_name as cust_nam5_0_0_, customer0_.cust_phone as cust_pho6_0_0_, customer0_.cust_source as cust_sou7_0_0_ from cst_customer customer0_ where customer0_.cust_id=?
//        Hibernate: delete from cst_customer where cust_id=?
        // 底层操作：先用主键查询，再根据主键进行删除

    }

    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }

    }


    /**
     * 测试统计查询，查询客户的总数量
     *  count: 统计总条数
     *
     */
    @Test
    public void testCount() {
        long count = customerDao.count();// 查询全部的客户数量
        System.out.println(count);

    }


    /**
     *  1. 判断id为4的客户是否存在
     *      查询下，若结果为空 则不存在。
     *  2. 判断db中id为4的客户的数量，若数量为0 则不存在
     *
     */
    @Test
    public void testExists() {
        boolean exists = customerDao.exists(4L);
        // Hibernate: select count(*) as col_0_0_ from cst_customer customer0_ where customer0_.cust_id=? and 1=1
        System.out.println(exists);

    }

    /**
     *  根据id从db中查询.
     *      注解Transactional，可保证getOne正常运行
     *
     *  区别：
     *      findOne(): 立即加载
     *      getOne(): getReference() 延迟加载
     *
     */
    @Test
    @Transactional
    public void testGetOne() {
        Customer one = customerDao.getOne(1l);
        System.out.println(one);

    }

}
