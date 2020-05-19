package com.lake.smartway.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/*
    1) SecurityCotroller : controller 생성후 3개의 Getmapping 생성
    2) Thymeleaf 의존성 추가
    3) index(누구든), home(어드민만), mypage(어드민, 인증자) 3개를 thymeleaf로 생성(templates밑에) index page에 <a href="/home">Home</a> 두개 생성
    4) 기본 static 패키지에 index 페이지 생성 후  http://localhost:8080 호출 -> 잘 열림 / 링크이동도 해봄
    5) spring security 의존성 추가
    6) 기본 static 패키지에 index 페이지 생성 후  http://localhost:8080 호출 -> spring에서 제공해주는 login page 열림
    7) 사용자ID : user    password : 웹서버 구동시마다 새로 생김 (Using generated security password: f6fdf8b0-fd9e-40f6-8fe7-a1050823bf47) 로그인해봄
      // 커스텀 시큐리티 시작
    8) SecurityConfig -> WebSecurityConfigurerAdapter 상속받는 Bean등록해서 인증할 요청과 안할 요청 정의
    9) Account, AccountService, AccountRepository : entity,service,repository 생성
    10) AccountService -> UserDetailsService 상속받는 bean을 등록해서 실제 User 생성및 인증 로직 추가
    11) 실행 해봄 : encoding 관련 error 발생
    11) spring security에서 passwordEncoder Bean생성 후 password encoding 로직 추가
    12) 권한 로직 추가
 */
@Controller
public class SecurityCotroller {

    @GetMapping("/thymeIndex")
    public String showAnyone(){
        return "thymeIndex";
    }

    @GetMapping("/my")
    public ModelAndView showAuthenticatedUser(Authentication authentication) {
        //Controller에 Authentication 파라미터를 선언해주면 Spring에서 자동으로 authentication 객체를 넘겨줌 ( 아래 한줄 생략 가능 )
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();SecurityCotroller
        User user = (User)authentication.getPrincipal();
        ModelAndView modelAndView = new ModelAndView("my");
        modelAndView.addObject("name", user.getUsername());
        return modelAndView;
    }

    @GetMapping("/secu")
    public ModelAndView ShowAdminUser(Authentication authentication){
        User user = (User)authentication.getPrincipal();
        // View 단으로 넘겨서 Grant(권한)을 확인해 보기 위해서 처리하는거임
//        Collection<GrantedAuthority> baseAuthorities = ((User) authentication.getPrincipal()).getAuthorities();
//        GrantedAuthority baseAuth = baseAuthorities.iterator().next();

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities(); // 권한 정보 리스트
        SimpleGrantedAuthority auth = authorities.iterator().next(); // 첫번째 권한

        ModelAndView modelAndView = new ModelAndView("secu");
        modelAndView.addObject("name", user.getUsername());
        modelAndView.addObject("grant", auth.getAuthority());
        return modelAndView;
    }

}
