package com.lake.smartway.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SliceTestController {
    Logger logger = LoggerFactory.getLogger(SliceTestController.class);

    @Autowired
    SampleService sampleService;

    @GetMapping("/helloSlice")
    public String hello() throws Exception{
        logger.debug("========SliceTestController===========");
        logger.debug("lakeman");
        logger.debug("skip");
        logger.debug("=====================================");

        return "hello " + sampleService.getName();
    }
}
