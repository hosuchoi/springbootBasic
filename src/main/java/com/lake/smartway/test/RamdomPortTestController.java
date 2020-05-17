package com.lake.smartway.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RamdomPortTestController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/helloRamdom")
    public String hello(){
        return "hello " + sampleService.getName();
    }

}
