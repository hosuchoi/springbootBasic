package com.lake.smartway.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

    @GetMapping("restClientHello")
    public String hello() throws InterruptedException {
        Thread.sleep(5000l);
        return "hello";
    }

    @GetMapping("restClientWorld")
    public String world() throws InterruptedException {
        Thread.sleep(4000l);
        return "world";
    }
}
