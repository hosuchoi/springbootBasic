package com.lake.smartway.profile;

import com.lake.smartway.properties.ClassProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileRunner implements ApplicationRunner {

    @Autowired
    private String hello;

    @Autowired
    private ClassProperties classProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========profile==========");
        System.out.println(hello);
        System.out.println("========profile==========");

        System.out.println("========profile properties file==========");
        System.out.println(classProperties.getName());
        System.out.println(classProperties.getFullName());
        System.out.println("========profile properties file==========");
    }
//    vm : -Dfoo
//    application : --bar --spring.profiles.active=prod
}
