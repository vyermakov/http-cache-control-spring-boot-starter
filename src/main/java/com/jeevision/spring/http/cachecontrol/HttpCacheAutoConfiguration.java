package com.jeevision.spring.http.cachecontrol;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@ComponentScan(basePackages = "com.jeevision.spring.http.cachecontrol")
public class HttpCacheAutoConfiguration {

}