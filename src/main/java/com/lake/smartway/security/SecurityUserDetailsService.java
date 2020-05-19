package com.lake.smartway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
/*   
    UserDetailsService 
        - Spring Security에서 User정보가 자동 생성 안됨
        - 인증시 loadUserByUsername 메서드 자동 호출하여 DB의 유저정보 조회 후 UserDetails 객체 반환
        - UserDetails는 커스텀한 유저정보를 담기 위한 어탭터제공(UserDetails - Principal - User(객체 사용))
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUsername = accountRepository.findByUsername(username);
        Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(account.getUsername(), account.getPassword(), authorities(account.getRole()));
    }

    private Collection<? extends GrantedAuthority> authorities(String role) {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        return Set.of(new SimpleGrantedAuthority(role)); //SimpleGrantedAuthority : 단순한 권한 저장 가능 (String 문자열 형태로..)
    }

    /*
    spring security에서 passwordEncoder는 강요임.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
