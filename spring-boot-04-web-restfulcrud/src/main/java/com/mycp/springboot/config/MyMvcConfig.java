package com.mycp.springboot.config;

import com.mycp.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置类 代替 配置文件
 * 使用WebMvcConfigurerAdapter 扩展SpringMVC
 * @author lq
 * create 2019-11-19 19:51
 */
@SuppressWarnings("deprecation")
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {






    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);

        // 浏览器发送 /mycp 请求来到success
        registry.addViewController("/mycp").setViewName("success");

    }


    // 所有的WebMvcConfigurerAdapter 都会一起起作用
    @Bean // 将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {



            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 视图映射
                registry.addViewController("/").setViewName("login"); // 当url中访问 / 时，响应视图 templates/login.html
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/",
//                                "/user/login", "/assets/**", "/webjars/**");

            }

        };



        return adapter;
    }


    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }


}













