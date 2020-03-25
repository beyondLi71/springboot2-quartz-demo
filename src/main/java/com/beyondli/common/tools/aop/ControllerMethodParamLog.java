package com.beyondli.common.tools.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * @author beyondLi
 * @desc  打印controller的请求信息.
 */
@Component
@Aspect
@Log
public class ControllerMethodParamLog {

    /**
     * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
     */
    @Pointcut("execution(* com.beyondli.controller..*(..))")
    public void aspect() {

    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * @param point 切入点
     */
    @Before("aspect()")
    public void before(JoinPoint point) {
        //获取方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        //访问路径
        List<Annotation> annotations = Arrays.asList(signature.getMethod().getDeclaredAnnotations())
                .stream()
                .filter(annotation -> annotation.annotationType() == RequestMapping.class)
                .collect(Collectors.toList());
        String requestPath = annotations.size() >= 1
                ? signature.getMethod().getAnnotation(RequestMapping.class).value()[0] : "";
        String className = point.getSignature().getDeclaringType().getSimpleName();
        String methodName = point.getSignature().getName();

        //请求路径，类名，方法名，参数列表
        log.log(Level.INFO, "\n---------请求路径: " + requestPath
                + "\n---------类名: " + className
                + "\n---------方法: " + methodName
                + "\n---------参数: {" + getArgs(point) + "}");

    }

    private String getArgs(JoinPoint point) {
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterNames[i] + ":" + point.getArgs()[i].toString() + "; ");
        }

        return sb.toString();
    }

}
