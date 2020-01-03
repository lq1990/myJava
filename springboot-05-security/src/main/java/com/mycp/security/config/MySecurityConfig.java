package com.mycp.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 自定义授权规则
 *  继承WebSecurityConfigurerAdapter
 *
 * @author lq
 * create 2020-01-03 17:24
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 重写此方法，设置访问权限即 授权规则
     *
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 定制请求的授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")  // VIP1有权访问 level1
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        // 开启自动配置的登录功能，是spring security 自动提供的。效果：若发起请求时 当没有权限时就会来到登录页面
        http.formLogin();
        // 1. /login来到登录页
        // 2. 重定向到 /login?error 表示登录失败
        // 3. 更多详细规定...


        http.logout().logoutSuccessUrl("/"); // 注销成功以后来到首页
        // 1. 访问 /logout 表示用户注销，清空session
        // 2. 注销成功，会返回 http://localhost:8080/login?logout


    }

    /**
     *  定义认证规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

//        auth.jdbcAuthentication()   // 可以使用jdbc进行认证规则设定

        // 为了演示方便，使用如下。本质上应使用db
        auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())

                .withUser("zhangsan")
                .password("123456")
                .roles("VIP1")

                .and()
                .withUser("lisi")
                .password("123456")
                .roles("VIP1", "VIP2")

                .and()
                .withUser("wangwu")
                .password("123456")
                .roles("VIP1", "VIP2", "VIP3");


    }
}
