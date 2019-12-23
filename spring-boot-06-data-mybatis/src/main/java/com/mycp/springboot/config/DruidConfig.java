package com.mycp.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lq
 * create 2019-12-17 22:29
 */
@Configuration
public class DruidConfig {

    // 把我们自己的数据源注册进来
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    // 配置Druid的监控
    // 1. 配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {

        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                        "/druid/*");

        Map<String, String> initP = new HashMap<>();

        initP.put("loginUsername", "root");
        initP.put("loginPassword", "123456");
        initP.put("allow", "");

        bean.setInitParameters(initP);
        return bean;
    }

    // 2. 配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initP = new HashMap<>();
        initP.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initP);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }



}
