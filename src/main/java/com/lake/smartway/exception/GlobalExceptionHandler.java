package com.lake.smartway.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //global exception : 전역 예외 처리 Controller 앞단 (AOP 사용)
@RestController //전역 예외처리는 controller의 중 하나이다
public class GlobalExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = BaseException.class)
//    public String handleBaseException(BaseException e){
//        return e.getMessage();
//    }

    /*
        Exception 우선 순위
        1) Controller Exception : Controller 내의 ExceptionHandler를 선언한 case
        2) Global Excpetion : @ControllerAdvice 통한 Exception class를 생성하여 선언한 case
        3) classpath:/static/error 밑의 html : error코드.html 선언 ( 404.html, 5xx.html 등.. )
     */
    @ExceptionHandler(value = ArithmeticException.class)
    public Map<String, String> handleArithMaticException(ArithmeticException e){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("errorMsg", e.getMessage());
        stringStringHashMap.put("status", "error");

        return stringStringHashMap;
    }

    @ExceptionHandler(value = Exception.class)  // 위에서 부터 순차적으로 찾기 때문에 Exception.class는 가장 아래 (Exception.class는 조상님 중 짱)
    public Map<String, String> handleException(Exception e){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("errorMsg", e.getMessage());
        stringStringHashMap.put("status", "error");

        return stringStringHashMap;
    }
}
