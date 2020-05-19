package com.lake.smartway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(AccountRunner.class);

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String authenticatedUser = "lake";
        Optional<Account> authenUser = accountRepository.findByUsername(authenticatedUser);
        if(!authenUser.isPresent()){
            //인증된 유저
            Account athenticatiedAccount = accountService.createUser(authenticatedUser, "1234");
            logger.debug("authenticatedUser : {},  password : {}" , athenticatiedAccount.getUsername(), athenticatiedAccount.getPassword());
        }else{
            logger.debug("Already exist : {}", authenticatedUser);
        }

        String adminUer = "admin";
        Optional<Account> adUser = accountRepository.findByUsername(adminUer);
        if(!adUser.isPresent()){
            //admin 유저
            Account adminAccount = accountService.createUser(adminUer, "1234");
            logger.debug("adminUer : {},  password : {}", adminAccount.getUsername(), adminAccount.getPassword());
        }else{
            logger.debug("Already exist : {}", adminUer);
        }
    }
}
