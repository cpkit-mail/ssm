package com.ssm.interceptor.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor2 extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(CommonInterceptor2.class);

    /**
     * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        log.info("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        log.info("requestUri:" + requestUri);
        log.info("contextPath:" + contextPath);
        log.info("url:" + url);

        String username = (String) request.getSession().getAttribute("user");
        if (username == null) {
            log.info("保存上个页面的url");
            request.getSession().setAttribute("redirectUrl", url);

            log.info("Interceptor：跳转到login页面！");
            // 抛出一个自定义的AuthorizationException异常跳转到login页面
            throw new AuthorizationException();
        } else
            return true;
    }

}
