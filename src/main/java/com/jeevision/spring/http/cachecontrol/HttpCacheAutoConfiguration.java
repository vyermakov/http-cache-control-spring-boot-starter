package com.jeevision.spring.http.cachecontrol;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnWebApplication
@Import(HttpCacheAspect.class)
public class HttpCacheAutoConfiguration {

}