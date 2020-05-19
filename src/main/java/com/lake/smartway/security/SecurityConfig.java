package com.lake.smartway.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
    WebSecurityConfigurerAdapter 
        - Spring Security가 제공하는 SecurityAutoConfiguration 동작을 안함
        - password 자동생성을 안해줌
        - 특정 request에 대한 권한 설정
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Web Server ( 정적 컨텐츠 : html,css,js등...) 들어올때 인증 처리 (여기 webserver는 tomcat)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/docs/**"); // Rest Docs 관련 경로 추가
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()); // resources/static 폴더 밑의 atCommonLocations 타입 모두 허용
    }

    // WAS ( 동적 컨테츠 ( 로직처리, cud 등등...) 사용하는곳 -> Spring boot 로직 서버
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //요청에 대한 인증 처리
//                .antMatchers("/thymeIndex","/index.html","/secu").permitAll() // 해당 요청만 인증 없이 허용
                .mvcMatchers("/secuIndex").permitAll() // 인증없이 허용
                .mvcMatchers("/admin").hasRole("ADMIN")  // ROLE_ADMIN 역할만 허용 (자동생성 : "ROLE_")
                .anyRequest().authenticated() // 그외 요청은 모두 인증 필요
                .and() // and() : 메서드 체인
                .formLogin() // form 로그인을 사용 : (my(인증정보없는경우)는 왜 form 로그인에 걸리지? accept header에 html에 있는 경우 여기에 걸림 그외는 아래의 httpBasic)
                .and()
                .httpBasic(); // httpBasicAuthentication 을 사용 : HTTP 기본 인증 프로토컬 (200 정상 404 디렉토리x 500 내부소스 401 인증실패등..)
    }
}
