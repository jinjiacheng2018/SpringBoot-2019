package com.tgram.sboot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter
{
    /**
     * 初始化方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.err.println("MyFilter Init Method...");
    }

    /**
     * 过滤方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        // 设置字符编码
        // servletRequest.setCharacterEncoding("UTF-8");
        // servletResponse.setCharacterEncoding("UTF-8");
        // servletResponse.setContentType("text/html");

        // 类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("MyFilter DoFilter Method, URL: " + request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy()
    {
        System.err.println("MyFilter Destroy Method...");
    }
}
