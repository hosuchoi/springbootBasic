package com.lake.smartway.mvc;

import org.springframework.web.bind.annotation.*;

@RestController() //@ResponseBody 생략가능
public class MvcController {

    //@Controller의 경우 아래 소스를 view를 찾으려고 함. 하지만 해당 소스는 restController이므로 requestBody가 생략
    @GetMapping("/users/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }
}
