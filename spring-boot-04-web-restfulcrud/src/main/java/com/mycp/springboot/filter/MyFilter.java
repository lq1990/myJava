package com.mycp.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lq
 * create 2019-11-23 14:57
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
