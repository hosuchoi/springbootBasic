package com.lake.smartway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createUser(String username, String password, String role){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password)); //{bcrypt}$2a$10$g25fVlqYjO4BSbbTJB465.ZXCjE22vfuqYHaRuAM3Mp0lN/5iLviG
        account.setRole(role);
        return accountRepository.save(account);
    }
}
