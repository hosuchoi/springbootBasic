package com.lake.smartway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(AccountRunner.class);

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = accountService.createUser("lake", "1234");
        logger.debug("usernmae : " + account.getUsername() + " password : " + account.getPassword());
    }
}
