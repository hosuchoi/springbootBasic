package com.lake.smartway.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DirectProperties implements ApplicationRunner {

    /*
    application.properties 우선 순위 ( 높은게 낮은걸 덮어씀 )
    1. file:./config/
    2. file:./
    3. classpath:/config/
    4. classpath:/
     */

    //Value 어노테이션 방식은 SpEL (Spring Explession languge) 사용 가능
    @Value("${app.name}") //application.properties 파일의 값 직접 꺼내오기
    private String name;

    @Value("${app.fullName}") //application.properties 파일의 값 직접 꺼내오기
    private String fullName;

    @Value("${app.randomValue}") //application.properties 파일의 값 직접 꺼내오기
    private int radomValue;

    /*
    ClassProperties 파일
    */
    @Autowired
    ClassProperties classProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=======direct properties============");
        System.out.println(name);
        System.out.println(fullName);
        System.out.println(radomValue);
        System.out.println("=======direct properties============");

        System.out.println("=======Class properties============");
        System.out.println(classProperties.getName());
        System.out.println(classProperties.getFullName());
        System.out.println(classProperties.getRandomValue());
        System.out.println(classProperties.getSessionTimeout()); //springboot의 duration이라는 특이한 컨버터 타입 ( application.properties에서는 문자열로 입력했지만 -> duration으로 변환 )
        System.out.println("=======Class properties============");
    }


}
