package com.panodata.interceptor.aop;

import com.alibaba.fastjson.JSON;
import com.panodata.conf.response.ResponseErrorEnum;
import com.panodata.conf.response.RestResultGenerator;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Aspect 当前类标识为一个切面供容器读取
 * Created by wp_sp on 2017/3/31.
 */
@Aspect
@Configuration
public class BaseAopInterceptor {
    private Logger logger = Logger.getLogger(BaseAopInterceptor.class);

    // 定义切点Pointcut
    @Pointcut("execution(* com.panodata.manager.auth..*.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        //请求链路时间戳
        String currentTimeMillis = request.getAttribute("currentTimeMillisID").toString();
        //请求地址
        String url = request.getRequestURL().toString();
        //请求方式
        String method = request.getMethod();
        //uri
        String uri = request.getRequestURI();
        //商户名
        String merchantName = request.getParameter("merchantName");

        Object i = request.getAttribute("AuthStatus");

        if (i.equals(ResponseErrorEnum.ERROR_A07)) {
            logger.info("请求时间戳----"
                    + currentTimeMillis
                    + "----商户----" + merchantName
                    + "----请求异常----" + ResponseErrorEnum.ERROR_A07);
            return RestResultGenerator.genErrorResult(ResponseErrorEnum.ERROR_A07);
        }

        logger.info("请求时间戳----"
                + currentTimeMillis
                + "----商户----" + merchantName
                + "----请求开始, 各个参数, url: " + url + ", method: " + method + ", uri: " + uri);
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        logger.info("请求时间戳----"
                + currentTimeMillis
                + "----商户----"
                + merchantName
                + "----请求结束，url: " + url + ", method: " + method + ", uri: " + uri + "----返回值是------ " + JSON.toJSONString(result));
        return result;
    }
}
