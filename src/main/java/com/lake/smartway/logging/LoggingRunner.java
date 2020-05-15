package com.lake.smartway.logging;

import com.lake.smartway.properties.ClassProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoggingRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

    @Autowired
    ClassProperties classProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("========Logging============");
        logger.debug(classProperties.getName());
        logger.debug(classProperties.getFullName());
        logger.debug("========Logging============");
    }
}
