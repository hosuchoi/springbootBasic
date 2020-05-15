package com.lake.smartway.applicationListener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // ApplicationRunner 여러개인 경우 순서 지정 ( 1 이 가장 먼저 실행됨 )
public class RunnerTest implements ApplicationRunner {  //ApplicationRunner 서버가 다 실행 된 후 수행
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============Runner Arguments================");
        System.out.println("RunnerTest foo : " + args.containsOption("foo"));  //VM 옵션 (jvm은 arguments는 application arguments가 아니라서 "false")
        System.out.println("RunnerTest bar : " + args.containsOption("bar"));  //aplication arguments 옵션  ( -- 옵션 )
        System.out.println("============Runnert Arguments================");
    }
}
