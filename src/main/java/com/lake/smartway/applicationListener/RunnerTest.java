package com.lake.smartway.applicationListener;

import com.lake.smartway.aop.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // ApplicationRunner 여러개인 경우 순서 지정 ( 1 이 가장 먼저 실행됨 )
public class RunnerTest implements ApplicationRunner {  //ApplicationRunner 서버가 다 실행 된 후 수행
    Logger logger = LoggerFactory.getLogger(RunnerTest.class);
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("============Runner Arguments================");
        logger.debug("RunnerTest foo : " + args.containsOption("foo"));  //VM 옵션 (jvm은 arguments는 application arguments가 아니라서 "false")
        logger.debug("RunnerTest bar : " + args.containsOption("bar"));  //aplication arguments 옵션  ( -- 옵션 )
        logger.debug("============================================");
    }
}
