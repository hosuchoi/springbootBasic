package com.lake.smartway.account;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restController")
public class AccountController {
    
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/string")
    public String getUrl(){
        return "hello world";
    }
//    http://localhost:8080/restController/account/?id=userId&pwd=userpwd
//    @GetMapping("/account")
//    public AccountDVO getAccount(@RequestParam(value = "id", required = false, defaultValue = "default id") String id,
//                                    @RequestParam(value = "pwd", required = false, defaultValue = "default pwd") String pwd){
//        AccountDVO accountDVO = new AccountDVO();
//        accountDVO.setId(id);
//        accountDVO.setPwd(pwd);
//
//        return accountDVO;
//    }

//    http://localhost:8080/restController/account/userId/userpwd
//    @GetMapping("/account/{id}/{pwd}")
//    public AccountDVO getAccount(@PathVariable(name = "id") String id,
//                                 @PathVariable(name = "pwd") String pwd){
//        AccountDVO accountDVO = new AccountDVO();
//        accountDVO.setId(id);
//        accountDVO.setPwd(pwd);
//
//        return accountDVO;
//    }

//    http://localhost:8080/tree/account
    @PostMapping("/account")
    public AccountDVO getAccount(@RequestBody AccountDVO req){
        logger.debug("사용자 조회");
        AccountDVO accountDVO = new AccountDVO();
        accountDVO.setId(req.getId());
        accountDVO.setPwd(req.getPwd());

        return accountDVO;
    }


    @GetMapping("list")
    public @ResponseBody
    ResponseEntity<List<AccountDVO>> listAccount(){
        AccountDVO accountDVOs = new AccountDVO();
        accountDVOs.setId("id");
        accountDVOs.setPwd("pwd");

        AccountDVO accountDVO1 = new AccountDVO();
        accountDVO1.setId("id2");
        accountDVO1.setPwd("pwd2");

        ArrayList<AccountDVO> accountArrayList = new ArrayList<AccountDVO>();
        accountArrayList.add(accountDVOs);
        accountArrayList.add(accountDVO1);

        return new ResponseEntity<>(accountArrayList, HttpStatus.OK);
    }
}
