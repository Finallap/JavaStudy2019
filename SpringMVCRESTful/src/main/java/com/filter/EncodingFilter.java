package com.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @description: EncodingFilter
 * @date: 2020/5/7 14:43
 * @author: Finallap
 * @version: 1.0
 */
public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("字符过滤器...");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        //请求放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
