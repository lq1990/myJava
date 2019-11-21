package com.mycp.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 在login页面上，点击链接(中英文)切换国际化。
 * 可以在链接上携带区域信息
 * @author lq
 * create 2019-11-20 11:59
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest req) {
        String l = req.getParameter("l");
        Locale loc = Locale.getDefault(); // OS默认的
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            loc = new Locale(split[0], split[1]); // language, country
        }
        return loc;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
