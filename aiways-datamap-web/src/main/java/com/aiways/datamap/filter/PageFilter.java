package com.aiways.datamap.filter;

import com.aiways.datamap.util.PageUtils;
import com.aiways.datamap.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 分页过滤器-处理pageNum和pageSize的入参 . <br>
 *
 */
@WebFilter(filterName = "pageFilter")
public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        PageUtils.setPageNum(getPageNum(httpRequest));
        PageUtils.setPageSize(getPageSize(httpRequest));
        try {
            chain.doFilter(request, response);
        } finally {
            // 由于tomcat线程重用,记得清空
            PageUtils.removePageNum();
            PageUtils.removePageSize();
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 获取前台传过来的页数-默认1
     *
     * @param httpRequest
     * @return
     */
    private int getPageNum(HttpServletRequest httpRequest) {
        int pageNum = 1;
        String param = httpRequest.getParameter("pageNum");
        Integer checkPageNum = StringUtils.stringToInteger(param);
        if (checkPageNum != null) {
            return checkPageNum;
        }
        return pageNum;
    }

    /**
     * 获取前台传过来的每页记录数-默认10
     *
     * @param httpRequest
     * @return
     */
    private int getPageSize(HttpServletRequest httpRequest) {
        int pageSize = 10;
        String param = httpRequest.getParameter("pageSize");
        Integer checkPageSize = StringUtils.stringToInteger(param);
        if (checkPageSize != null) {
            return checkPageSize;
        }
        return pageSize;
    }

}
