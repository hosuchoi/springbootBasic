package com.lake.smartway.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    1) controller 생성후 2개의 Getmapping 생성
    2) index, home, mypage 3개를 thymeleaf로 생성(templates밑에) index page에 <a href="/home">Home</a> 두개 생성
    4) 기본 static 패키지에 index 페이지 생성 후  http://localhost:8080 호출 -> 잘 열림 / 링크이동도 해봄
    5) spring security 의존성 추가
    6) 기본 static 패키지에 index 페이지 생성 후  http://localhost:8080 호출 -> spring에서 제공해주는 login page 열림
    7) 사용자ID : user    password : 웹서버 구동시마다 새로 생김 (Using generated security password: f6fdf8b0-fd9e-40f6-8fe7-a1050823bf47)
    8) entity,service,repository 생성
    9) SecurityConfig -> WebSecurityConfigurerAdapter 상속받는 Bean등록해서 인증할 요청과 안할 요청 정의
    10) AccountService -> UserDetailsService 상속받는 bean을 등록해서 실제 User 생성및 인증 로직 추가
    11) spring security에서 passwordEncoder 생성
 */
@Controller
public class SecurityCotroller {

    @GetMapping("/secu")
    public String hello(){
        return "secu";
    }

    @GetMapping("/my")
    public String my(){
        return "my";
    }
}
