package com.epam.tm.news.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AllowFilter")
public class AllowFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse myResponse = (HttpServletResponse) servletResponse;
        MyResponseRequestWrapper responseWrapper = new MyResponseRequestWrapper(myResponse);
        responseWrapper.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        filterChain.doFilter(servletRequest, myResponse);
    }

    @Override
    public void destroy() {

    }


}
