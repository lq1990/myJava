package com.mycp.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自定义的错误属性.
 * 注意：DefaultErrorAttributes 是 web.servlet.error 的
 *
 * @author lq
 * create 2019-11-23 12:19
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {


    // 返回的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(
            WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "mycp");

        // 异常处理器携带的数据。从req作用域取出
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);// 0: request scope
        map.put("ext", ext);

        return map;
    }

}
