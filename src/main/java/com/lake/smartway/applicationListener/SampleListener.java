package com.lake.smartway.applicationListener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {  //ApplicationStartedEvent 는 Application Context가 만들어지기 전에 이벤트 발생

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("=============================");
        System.out.println("Application is starting");
        System.out.println("=============================");
    }
}
