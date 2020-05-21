package com.lake.smartway.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class TokenRequiredAspect {
    Logger logger = LoggerFactory.getLogger(TokenRequiredAspect.class);

    @Before("@annotation(tokenRequired)")
    public void tokenRequiredWithAnnotation(TokenRequired tokenRequired) throws Throwable {
        logger.debug("==========AOP Before @annotation(tokenRequired) ================");
        logger.debug("Before tokenRequiredWithAnnotation");
        logger.debug("================================================================");
    }
}
