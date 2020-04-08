package com.liuyewei.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: liuyewei
 * Date: 2020/1/8
 * Time: 9:14 下午
 * Description:
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义一个切面,该路径下所有请求会被切割
    @Pointcut("execution(* com.liuyewei.controller.*.*(..))")
    public void log(){

    }

    //在路径下类请求前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //获取url 访问者IP 调用方法 参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);

        logger.info("Request : {}", requestLog);
    }

    //在路径下类请求后执行
    @After("log()")
    public void doAfter() {
        logger.info("------doAfter------");
    }

    //最后执行返回，在After之后
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("Result : {}", result);
    }

    private class RequestLog{
        //请求url
        private String url;
        //访问者ip
        private String ip;
        //调用方法
        private String classMethod;
        //参数
        private Object[] args;

        //传参构造
        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        //转化为字符串
        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
