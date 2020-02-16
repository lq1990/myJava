package cn.wendaocp.dubbo.service.impl;

import cn.wendaocp.dubbo.bean.Order;
import cn.wendaocp.dubbo.bean.User;
import cn.wendaocp.dubbo.service.UserService;

/**
 * @author lq
 * create 2020-02-16 12:07
 */
public class UserServiceImpl implements UserService {


    @Override
    public Order buyNewMovie(User user) {
        // 1. 远程查询最新电影并返回

        // 2. 封装order对象返回
        Order order = new Order();
        order.setUserName(user.getUserName());
        return order;
    }

}
