package com.lake.smartway.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockTestController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello(){
        return "hello " + sampleService.getName();
    }
}
