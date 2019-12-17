package com.mycp.test;

import com.mycp.dao.CustomerDao;
import com.mycp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author lq
 * create 2019-12-04 19:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据条件，查询单个对象
     *
     */
    @Test
    public void testSpec() {

        // 匿名内部类
        /**
         * 自定义查询条件：
         *  1. 实现Specification接口（提供泛型，查询的对象类型）
         *  2. 实现toPredicate方法，构造查询条件
         *  3. 需要借助方法参数中的两个参数，
         *      root：获取需要查询的对象属性
         *      CriteriaBuilder: 构造查询条件的，内部封装了很多的查询条件（模糊匹配，精准匹配）
         *
         *  案例：根据客户名称查询，查询客户名为 刀刀 的客户
         *      查询条件：
         *          1. 查询方式
         *              cb对象中
         *          2. 比较的属性名称
         *              root对象
         *
         */
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // 1. 获取比较的属性
                Path<Object> custName = root.get("custName");
                // 2. 构造查询条件。参数1：需要比较的参数，2. 取值
                Predicate pred = criteriaBuilder.equal(custName, "刀刀刀");// 进行精准匹配(比较的属性)

                return pred;
            }
        }; // 泛型是 要查询的对象


        Customer one = customerDao.findOne(spec);
        System.out.println(one);

    }


    /**
     * 多条件查询
     *  案例：根据客户名 和 客户所属行业查询
     *
     *
     */
    @Test
    public void testSpec1() {

        /**
         * root: 获取属性
         *  客户名
         *  所属行业
         *
         * cb：构造查询
         *  1. 构造客户名的精准匹配查询
         *  2. 构造所属行业的精准匹配查询
         *  3. 将以上两个查询联系
         */
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");

                Predicate p1 = criteriaBuilder.equal(custName, "刀刀");
                Predicate p2 = criteriaBuilder.equal(custIndustry, "科技");

                // 联合
                Predicate pred = criteriaBuilder.and(p1, p2);// 以与的形式拼接多个查询条件
//                criteriaBuilder.or(); // 以或的形式拼接

                return pred;
            }
        };

        Customer one = customerDao.findOne(spec);
        System.out.println(one);
    }

    /**
     * 案例：模糊查询，返回列表
     *
     * 区别equal方法，传path对象即可。
     * gt, lt, ge, le, like : 得到path对象，根据path指定比较的参数类型，再去进行比较
     *  指定参数类型：path.as(类型的字节码对象)
     *
     */
    @Test
    public void testLike() {

        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                // 查询属性：客户名
                Path<Object> custName = root.get("custName");

                // 查询方式：模糊查询
                Predicate pred = criteriaBuilder.like(custName.as(String.class), "刀刀%");

                return pred;
            }
        };

//        List<Customer> all = customerDao.findAll(spec);

        // 创建排序对象
        Sort sort = new Sort(Sort.Direction.DESC, "custId");
        List<Customer> all = customerDao.findAll(spec, sort);
        for (Customer customer : all) {
            System.out.println(customer);
        }

    }

    @Test
    public void testPage() {
        Specification spec = new Specification() {
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };

        Pageable pageable = new PageRequest(0,2); // 当前查询的页数（从0开始）；每页查询的数量；

        Page<Customer> page = customerDao.findAll(spec, pageable);//带有条件的分页。 第二个参数：分页参数，查询的页码，每页查询的条数
        System.out.println(page.getTotalElements()); // 总条数
        System.out.println(page.getContent()); // 本页的 数据集合列表
        System.out.println(page.getTotalPages()); // 得到总页数


//        customerDao.findAll(page); // 没有条件的分页，会查所有。
        // 分页时用到的方法返回值：
        //  Page，spring data jpa封装好的pageBean对象，数据列表，总条数。


    }




}
