package com.lake.smartway.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
                .antMatchers("/h2-console/**").permitAll() // H2에 대한 인증 면제 ( antMatchers : ANT 방식 )
                .mvcMatchers("/secuIndex","/cors").permitAll() // 인증 면제
                .mvcMatchers("/admin").hasRole("ADMIN")  // ROLE_ADMIN 역할만 허용 (자동생성 : "ROLE_")
                .anyRequest().authenticated() // 그외 요청은 모두 인증 필요
//  모든 csrf 중지 , x-frame-option 중지
//                .and().csrf().disable()
//                .and().headers().frameOptions().sameOrigin()
// h2 관련 csrf 중지, h2관련 x-frame-option 중지 (추천)
                .and()
                .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("!/h2-console/**"))
                .and()
                .headers().addHeaderWriter(
                        new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'")).frameOptions().disable()
                .and()
                .formLogin() // form 로그인을 사용 : (my(인증정보없는경우)는 왜 form 로그인에 걸리지? accept header에 html에 있는 경우 여기에 걸림 그외는 아래의 httpBasic)
                .and()
                .httpBasic(); // httpBasicAuthentication 을 사용 : HTTP 기본 인증 프로토컬 (200 정상 404 디렉토리x 500 내부소스 401 인증실패등..)
    }
}

/*
//모든 csrf 중지
.and().csrf().disable()
// H2에 대한 CSRF 예외 처리 
.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("!/h2-console/**"))
-> Spring Security에서는 Cross Site Request Forgery(CSRF)를 방지 장치가 기본으로 탑재되어 있다.
하지만 H2 Console의 로그인 화면에는 CSRF 처리가 되어 있지 않으므로 403 forbiden 에러를 만나게 된다.
그렇다고 h2-console을 사용하기 위해 CSRF를 완전히 disable 하는 것은 애플리케이션 전체의 보안 수준이 낮아지므로 좋은 방법이 아니다.
대신에 h2-console에 대해서만 CSRF 면제 처리를 해주는 것이 좋다.

.and().headers().frameOptions().sameOrigin()   // X-Frame-Options도 sameOrigin 변경
.headers().addHeaderWriter(
                        new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'")).frameOptions().disable()  // h2만 중지
-> H2 무시 설정 관련하여 X-Frame-Options의 값이 DENY로 되어 있다.
X-Frame-Options도 아래와 같이 면제 처리를 해줘야 한다.

참고) X-Frame-Options
1) deny
어떠한 사이트에서도 frame 상에서 보여질 수 없습니다.
2) sameorigin
동일한 사이트의 frame에서만 보여집니다.
해당 스펙 안에서 브라우저 벤더가 최상위(top level), 혹은 부모(parent), 모든 체인(whole chain)에서 적용할지를 결정하도록 맡겨집니다.
 하지만 모든 조상(ancestor)이 동일한 사이트에서 제공되지 않으면 이 옵션은 그다지 유용하지 않다고 논의되고 있습니다.
(참고 bug 725490). 상세 지원사항에 대한 참고 Browser compatibility.
3) allow-from uri
지정된 특정 uri의 frame 에서만 보여집니다. 파이어폭스에서는 sameorigin 과 동일한 문제를 겪고 있습니다.
즉 동일한 사이트에 있는지에 대해서 frame의 조상(ancestor)을 확인하지 않습니다.
 */
