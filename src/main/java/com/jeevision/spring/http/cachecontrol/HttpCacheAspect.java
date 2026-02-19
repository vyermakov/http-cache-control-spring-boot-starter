package com.jeevision.spring.http.cachecontrol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletResponse;

@Aspect
@Component
public class HttpCacheAspect {

    @Around("@annotation(httpCache)")
    public Object addCacheHeaders(ProceedingJoinPoint joinPoint, HttpCache httpCache) throws Throwable {
        Object result = joinPoint.proceed();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = attributes.getResponse();

        if (response != null) {
            StringBuilder cacheControl = new StringBuilder();
            if (httpCache.cachePublic()) {
                cacheControl.append("public");
            } else {
                cacheControl.append("private");
            }
            cacheControl.append(", max-age=").append(httpCache.maxAgeSeconds());
            response.setHeader("Cache-Control", cacheControl.toString());
        }

        return result;
    }
}