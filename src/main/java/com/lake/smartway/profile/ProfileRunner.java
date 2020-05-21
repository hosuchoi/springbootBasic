package com.lake.smartway.profile;

import com.lake.smartway.properties.ClassProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(ProfileRunner.class);
    @Autowired
    private String hello;

    @Autowired
    private ClassProperties classProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("========profile==========");
        logger.debug(hello);
        logger.debug("==========================");

        logger.debug("========profile properties file==========");
        logger.debug(classProperties.getName());
        logger.debug(classProperties.getFullName());
        logger.debug("=========================================");
    }
//    vm : -Dfoo
//    application : --bar --spring.profiles.active=prod
}
