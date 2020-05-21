package com.lake.smartway.applicationListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    Logger logger = LoggerFactory.getLogger(StartedEventListener.class);
    
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        logger.debug("============ApplicationStartedEvent================");
        logger.debug("Application is started");
        logger.debug("===================================================");
    }
}
