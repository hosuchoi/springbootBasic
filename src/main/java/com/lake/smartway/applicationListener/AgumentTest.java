package com.lake.smartway.applicationListener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class AgumentTest {

    //특정 bean의 생성자가 하나고 그 생성자의 파라미터가 bean인 경우 그 bean는 spring에서 알아서 주입해줌
    public AgumentTest(ApplicationArguments arguments) {
        System.out.println("foo : " + arguments.containsOption("foo"));  //VM 옵션 (jvm은 arguments는 application arguments가 아니라서 "false")
        System.out.println("bar : " + arguments.containsOption("bar"));  //aplication arguments 옵션  ( -- 옵션 )
    }
}
