package com.lake.smartway.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class RelectionRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        private static final Logger logger = LoggerFactory.getLogger(RelectionRunner.class);
        final Logger logger = LoggerFactory.getLogger(RelectionRunner.class);

//        Class<?> relectionService = Class.forName("RelectionService");
//
//        Class<?>[] declaredClasses = relectionService.getDeclaredClasses();
//        logger.debug(declaredClasses.toString());
//
//        Method[] method = relectionService.getMethods();
//        logger.debug(method.toString());
//
//        Field[] fields = relectionService.getClass().getFields();
//        logger.debug(fields.toString());
//
//        Constructor<?>[] constructors = relectionService.getClass().getConstructors();
//        logger.debug(constructors.toString());
//
//        Class<?>[] interfaces = relectionService.getClass().getInterfaces();
//        logger.debug(interfaces.toString());
//
//        Class<?> superclass = relectionService.getClass().getSuperclass();
//        logger.debug(superclass.toString());


    }
}
