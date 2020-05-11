package com.lake.smartway.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tree")
public class TreeController {

    @GetMapping("/string")
    public @ResponseBody String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/account", method = {RequestMethod.GET})
    public @ResponseBody AccountDVO account(){
        AccountDVO accountDVO = new AccountDVO();
        accountDVO.setId("id");
        accountDVO.setPwd("pwd");

        return accountDVO;
    }

    @GetMapping("list")
    public @ResponseBody List<AccountDVO> listAccount(){
        AccountDVO accountDVO = new AccountDVO();
        accountDVO.setId("id");
        accountDVO.setPwd("pwd");

        AccountDVO accountDVO1 = new AccountDVO();
        accountDVO1.setId("id2");
        accountDVO1.setPwd("pwd2");

        ArrayList<AccountDVO> accountArrayList = new ArrayList<AccountDVO>();
        accountArrayList.add(accountDVO);
        accountArrayList.add(accountDVO1);

        return accountArrayList;
    }

    @RequestMapping(value = "/user", method = {RequestMethod.POST})
    public @ResponseBody AccountDVO userInfo(@RequestBody AccountDVO req){

        AccountDVO accountDVO = new AccountDVO();
        accountDVO.setId(req.getId());
        accountDVO.setPwd(req.getPwd());

        return accountDVO;
    }
}

