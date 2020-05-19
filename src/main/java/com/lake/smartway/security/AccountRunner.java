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
        String username = "lake";
        Optional<Account> byUsername = accountRepository.findByUsername(username);

        byUsername.ifPresent(account -> {logger.debug("Already exist : {}", account.getUsername());});
        if(!byUsername.isPresent()){
            Account userAccount = accountService.createUser(username, "1234", "ROLE_USER");
            logger.debug("Create User : {} / {} / {} / {} ", userAccount.getId(), userAccount.getUsername(), userAccount.role, userAccount.password);
        }

        username = "admin";
        byUsername = accountRepository.findByUsername(username);

        byUsername.ifPresent(account -> {logger.debug("Already exist : {}", account.getUsername());});
        if(!byUsername.isPresent()){
            Account userAccount = accountService.createUser(username, "1234", "ROLE_ADMIN");
            logger.debug("Create User : {} / {} / {} / {} ", userAccount.getId(), userAccount.getUsername(), userAccount.role, userAccount.password);
        }
    }
}
