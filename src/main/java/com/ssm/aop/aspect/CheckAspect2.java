package com.ssm.aop.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 根据注解实现AOP实现登录功能
 *
 */
@Aspect
public class CheckAspect2 {

    private static final Logger log = LoggerFactory.getLogger(CheckAspect2.class);

    // @Pointcut注解指定了切点
    @Pointcut("execution(* *.sleep())")
    public void sleeppoint() {
    }

    /**
     * 实现代码
     * 
     * @param call
     * @return
     * @throws Throwable
     */
    // 五种类型的通知：
    // Before(前)  org.apringframework.aop.MethodBeforeAdvice
    // After-returning(返回后) org.springframework.aop.AfterReturningAdvice
    // After-throwing(抛出后) org.springframework.aop.ThrowsAdvice
    // Arround(周围) org.aopaliance.intercept.MethodInterceptor
    // Introduction(引入) org.springframework.aop.IntroductionInterceptor
    // 指定了运行时的通知
    @Around("sleeppoint()")
    public Object aroundCheck(ProceedingJoinPoint call) throws Throwable {

        log.info("Aspect aroundCheck begin...");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();

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
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

            return false;
        } else
            return true;

        // Object[] args = call.getArgs();
        // if (args[0] == null || !(args[0] instanceof User)) {
        // throw new AuthorizationException();
        // }
        // User user = (User) (args[0]);
        //
        // return user;

    }
}