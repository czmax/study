package com.study.xyls.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ipaynow0929 on 2018/1/11.
 */

//拦截顺序
@Order(2)
//交给spring容器管理  去掉后filter失效
//@Component
//配置拦截路径
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class Log1Filter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        if (servletRequest != null) {
            request = (HttpServletRequest) servletRequest;
        }
        if (servletResponse != null) {
            response = (HttpServletResponse) servletResponse;
        }
        System.out.println(request.getQueryString());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
