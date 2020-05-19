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

@Controller
public class AccountController {

    @GetMapping("/secuIndex")
    public String showAnyone(){
        return "thymeIndex";
    }

    @GetMapping("/auth")
    public ModelAndView showAuthenticatedUser(Authentication authentication) {
        //Controller에 Authentication 파라미터를 선언해주면 Spring에서 자동으로 authentication 객체를 넘겨줌 ( 아래 한줄 생략 가능 )
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();SecurityCotroller
        User user = (User)authentication.getPrincipal();

        //명시적 타입 선언
//        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities(); // 권한 정보 리스트
//        SimpleGrantedAuthority auth = authorities.iterator().next(); // 첫번째 권한
        //인터페이스 타입으로 다 받겟다!
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        GrantedAuthority authority = authorities.iterator().next();

        ModelAndView modelAndView = new ModelAndView("my");
        modelAndView.addObject("name", user.getUsername());
        modelAndView.addObject("grant", authority.getAuthority());
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView ShowAdminUser(Authentication authentication){
        User user = (User)authentication.getPrincipal();
        // View 단으로 넘겨서 Grant(권한)을 확인해 보기 위해서 처리하는거임
//        Collection<GrantedAuthority> baseAuthorities = ((User) authentication.getPrincipal()).getAuthorities();
//        GrantedAuthority baseAuth = baseAuthorities.iterator().next();

        //명시적 타입 선언
//        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities(); // 권한 정보 리스트
//        SimpleGrantedAuthority auth = authorities.iterator().next(); // 첫번째 권한
        //인터페이스 타입으로 다 받겟다!
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        GrantedAuthority authority = authorities.iterator().next();

        ModelAndView modelAndView = new ModelAndView("secu");
        modelAndView.addObject("name", user.getUsername());
        modelAndView.addObject("grant", authority.getAuthority());
        return modelAndView;
    }

}
