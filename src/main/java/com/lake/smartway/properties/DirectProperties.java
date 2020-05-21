package com.lake.smartway.properties;

import io.jsonwebtoken.lang.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DirectProperties implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(DirectProperties.class);

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
        logger.debug("=======direct properties============");
        logger.debug(name);
        logger.debug(fullName);
        logger.debug(Integer.toString(radomValue));
        logger.debug("=====================================");

        logger.debug("=======Class properties============");
        logger.debug(classProperties.getName());
        logger.debug(classProperties.getFullName());
        logger.debug(Integer.toString(classProperties.getRandomValue()));
        logger.debug(classProperties.getSessionTimeout()+""); //springboot의 duration이라는 특이한 컨버터 타입 ( application.properties에서는 문자열로 입력했지만 -> duration으로 변환 )
        logger.debug("=====================================");
    }


}
