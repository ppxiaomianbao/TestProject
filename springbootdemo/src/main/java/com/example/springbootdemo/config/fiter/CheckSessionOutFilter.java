package com.example.springbootdemo.config.fiter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName: springbootdemo
 * @Package: com.example.springbootdemo.config.fiter
 * @ClassName: CheckSessionOutFiter
 * @Author: limingxing
 * @Description: todo 过滤器，如果sessin超时，就返回登录页面
 * @Date: 2019/9/1 12:30
 * @Version: 1.0
 */
public class CheckSessionOutFilter implements Filter {
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
