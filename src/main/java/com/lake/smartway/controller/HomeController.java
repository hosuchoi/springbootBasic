package com.lake.smartway.controller;

import com.lake.smartway.service.SecurityService;
import com.lake.smartway.service.SecurityServiceImpl;
import com.lake.smartway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject){
        String token = securityService.createToken(subject, 1000 * 60 * 60);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", subject);
        map.put("token", token);

        return map;
    }

    @GetMapping("security/get/subject")
    public String getSubject(@RequestParam String token){
        String subject = securityService.getSubejct(token);
        return subject;
    }

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Map<String, String> home(){
        Map<String, String> res = this.userService.getMessage();

        return res;
    }
}
