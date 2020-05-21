package com.lake.smartway.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /*
    execution 표현식 정리

    execution([수식어] 리턴타입 [클래스이름].이름(파라미터)
    수식어 : public, private 등 수식어를 명시합니다. (생략 가능)
    리턴타입 : 리턴 타입을 명시합니다.
    클래스이름 및 이름 : 클래스이름과 메서드 이름을 명시합니다. (클래스 이름은 풀 패키지명으로 명시해야합니다. 생략도 가능)
    파라미터 : 메서드의 파라미터를 명시합니다.
    " * " : 모든 값을 표현합니다.
    " .. " : 0개 이상을 의미합니다.

    EX)
    execution(public Integer com.edu.aop.*.*(*))
     - com.edu.aop 패키지에 속해있고, 파라미터가 1개인 모든 메서드

    execution(* com.edu..*.get*(..))
     - com.edu 패키지 및 하위 패키지에 속해있고, 이름이 get으로 시작하는 파라미터가 0개 이상인 모든 메서드

    execution(* com.edu.aop..*Service.*(..))
     - com.edu.aop 패키지 및 하위 패키지에 속해있고, 이름이 Service르 끝나는 인터페이스의 파라미터가 0개 이상인 모든 메서드

    execution(* com.edu.aop.BoardService.*(..))
     - com.edu.aop.BoardService 인터페이스에 속한 파마리터가 0개 이상인 모든 메서드

    execution(* some*(*, *))
     - 메서드 이름이 some으로 시작하고 파라미터가 2개인 모든 메서드


    within 명시자
    Ex)

    within(com.edu.aop.SomeService)
     - com.edu.aop.SomeService 인터페이스의 모든 메서드

    within(com.edu.aop.*)
     - com.edu.aop 패키지의 모든 메서드

    within(com.edu.aop..*)
     - com.edu.aop 패키지 및 하위 패키지의 모든 메서드

    bean 명시자
    Ex)

    bean(someBean)
     - 이름이 someBean인 빈의 모든 메서드

    bean(some*)
     - 빈의 이름이 some으로 시작하는 빈의 모든 메서드

    */

    //UserService의 모든 메서드
//    @Around("Bean(UserService)")
//    @Before("@annotation(tokenRequired")
    @Around("execution(* com.lake.smartway.service.UserService..*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("===================AOP AROUND com.example.smartway.service.UserService..*(..)=================");
        logger.debug("AOP around start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.debug("AOP around finished - " + pjp.getSignature().getDeclaringTypeName() + "/" + pjp.getSignature().getDeclaringTypeName());
        logger.debug("===============================================================================================");

        return result;
    }

    @Before("bean(UserService)")
    public void logger() throws Throwable {
        logger.debug("===================AOP Before bean(UserService)=================");
        logger.debug("AOP Before");
        logger.debug("================================================================");
    }

}
