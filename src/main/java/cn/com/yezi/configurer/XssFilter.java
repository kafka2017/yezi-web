package cn.com.yezi.configurer;


import cn.com.yezi.util.IpUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @date: 2021/5/12
 * @author: weixf
 */
@WebFilter(filterName="XssFilter", urlPatterns="/*")
public class XssFilter  implements Filter {

    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("过滤器初始化");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;

        String ip = IpUtil.getIp(request);

        System.out.println("执行过滤操作,请求IP:"+ip);

        filterChain.doFilter(new XSSRequestWrapper(request), servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
        this.filterConfig = null;
    }
}
