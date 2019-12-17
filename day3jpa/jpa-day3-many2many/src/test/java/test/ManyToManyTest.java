package test;

import com.mycp.dao.RoleDao;
import com.mycp.dao.UserDao;
import com.mycp.domain.Role;
import com.mycp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lq
 * create 2019-12-15 16:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    /**
     * 保存一个用户，保存一个角色
     *
     * 多对多放弃维护权，被动的一方放弃，所以Role一方放弃维护权
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testAdd() {
        User user = new User();
        user.setUserName("小明");

        Role role = new Role();
        role.setRoleName("java programmer");


        user.getRoles().add(role); // 配置用户到角色的关系，可以对中间表中的数据进行维护

        role.getUsers().add(user); // 角色对用户

        userDao.save(user);
        roleDao.save(role);

    }


    /**
     * 测试 级联
     * 保存一个用户的同时，保存这个用户的关联角色
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd() {
        User user = new User();
        user.setUserName("小明2");

        Role role = new Role();
        role.setRoleName("java programmer2");


        user.getRoles().add(role); // 配置用户到角色的关系，可以对中间表中的数据进行维护

        role.getUsers().add(user); // 角色对用户

        userDao.save(user);

    }


    /**
     * 测试 级联删除
     *
     *  级联删除 慎用
     *
     *
     */
    @Test
    @Transactional
    @Rollback(false) // 不自动回滚
    public void testCascadeRemove() {
        // 查询用户
        User one = userDao.findOne(1l);

        // 删除用户
        userDao.delete(one);

    }


}












