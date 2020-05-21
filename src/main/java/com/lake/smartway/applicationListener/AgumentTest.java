package com.lake.smartway.applicationListener;

import com.lake.smartway.aop.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class AgumentTest {
    Logger logger = LoggerFactory.getLogger(AgumentTest.class);

    //특정 bean의 생성자가 하나고 그 생성자의 파라미터가 bean인 경우 그 bean는 spring에서 알아서 주입해줌 ( 해당 bean은 이에 해당함 )
    public AgumentTest(ApplicationArguments arguments) {
        logger.debug("============bean Arguments================");
        logger.debug("foo : " + arguments.containsOption("foo"));  //VM 옵션 (jvm은 arguments는 application arguments가 아니라서 "false")
        logger.debug("bar : " + arguments.containsOption("bar"));  //aplication arguments 옵션  ( -- 옵션 )
        logger.debug("==========================================");
    }
}
