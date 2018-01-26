package com.hk.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by hekai on 2018/1/24.
 *
 * note:
 * 1.切面是水平思维的一种体现，而 spring boot 是一种纵向思维 application(controller -> service -> repository -> dao)
 * 2.对于数据库来说，spring 用 Hibernate 来对数据进行统一出入口操作
 * 3.切面在spring 框架内实现是一种非常好的做法，但他是基于 spring 的同一控制流这种模式下才能出现的？
 *      答案是错误的，很多框架都有这种对于控制流的横向控制
 * 4.实现多个切面时须确认类名
 */
@Aspect
@Component
public class UserAspect {

    private final static Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Pointcut("execution(public * com.hk.controller.UserController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void cutBefore(JoinPoint joinPoint) {
        logger.info("切前");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        logger.info("url={}", request.getRequestURL());

        // method
        logger.info("method={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // 类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // 参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void cutAfter() {
        logger.info("切后");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
