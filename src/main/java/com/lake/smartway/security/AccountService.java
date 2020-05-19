package com.lake.smartway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/*
    UserDetailsService 상속받은 우리가 만든 커스텀한 Bean 있어야
    Spring Security에서 User정보가 자동 생성 안됨
    -> 로그인 처리 할때 UserDetailsService의 loadUserByUsername(String s) 자동 호출됨
    -> spring에서 제공해주는 UserDetails는 커스텀한 유저정보를 담기 위한 인터페이스이고,
       이를 이용할 수 있는 UserDetails는 상속받은 User라는 구현체를 제공해준다.

    스프링에서 제공하는 기본 권한(Authority)
    ROLE_ANONYMOUS			모든 사용자
    IS_AUTHENTICATED_ANONYMOUSLY	익명 사용자
    IS_AUTHENTICATED_FULLY		인증된 사용자
    IS_AUTHENTICATED_REMEMBERED	REMEMBERED 사용자
    ROLE_RESTRICTED			제한된 사용자
    ROLE_USER			일반 사용자
    ROLE_ADMIN			관리자
 */
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createUser(String username, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password)); //{bcrypt}$2a$10$g25fVlqYjO4BSbbTJB465.ZXCjE22vfuqYHaRuAM3Mp0lN/5iLviG
        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUsername = accountRepository.findByUsername(username);
        Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(account.getUsername(), account.getPassword(), authorities(account.getUsername()));
    }

    private Collection<? extends GrantedAuthority> authorities(String username) {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        if("admin".equals(username)){
            return Set.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return Set.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
