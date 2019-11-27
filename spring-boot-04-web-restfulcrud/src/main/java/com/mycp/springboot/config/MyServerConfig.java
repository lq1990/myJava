package com.mycp.springboot.config;

import com.mycp.springboot.filter.MyFilter;
import com.mycp.springboot.listener.MyListener;
import com.mycp.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Arrays;

/**
 * 配置类代替原来的配置xml
 * @author lq
 * create 2019-11-23 14:47
 */
@Configuration
public class MyServerConfig {

    // 注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>(
                new MyServlet(), "/myServlet");

        bean.setLoadOnStartup(1);
        return bean;
    }

    // filter：对url进行过滤
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));

        return bean;
    }

    // listener
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> bean = new ServletListenerRegistrationBean<>(new MyListener());

        return bean;
    }




    // 配置嵌入式的servlet容器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {

        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            // 定制嵌入式的Servlet容器相关规则
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8083);

            }
        };
    }



}
