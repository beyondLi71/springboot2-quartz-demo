package com.beyondli.common.tools.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author beyondLi
 * @date 2017/9/27  11:03
 * @desc aop拦截demo
 */
@Component
//开关
@Aspect
public class ExampleAop {

    @Around("execution (* com.beyondli.controller..*.*(..))")
    public Object beforeCheckToken(ProceedingJoinPoint pro) throws Throwable {
        /**
       //设置Token值
        String token = null;
        //从cookie中取出所有属性值
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookie = request.getCookies(); //获取token
        String requestAddress = request.getRequestURI();  //取出请求地址
        if (cookie != null) {
            for (Cookie index : cookie) {
                if (index.getName().equals("BACK_TOKEN"))  //取出token值
                    token = index.getValue();
            }
        }
        **/
        //方法执行完成后执行的方法
        Object proceed = pro.proceed();
        return proceed;
    }
}
