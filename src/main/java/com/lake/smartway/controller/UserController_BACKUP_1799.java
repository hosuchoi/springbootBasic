package com.lake.smartway.controller;

import com.lake.smartway.aop.TokenRequired;
import com.lake.smartway.model.User;
import com.lake.smartway.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @TokenRequired
    @GetMapping
    public List<User> getAll(){
        logger.debug("debug mode : controller : 모든 사용자 조회");
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserByuserId(@PathVariable("userId") Integer userId){
        logger.debug("debug mode : controller : 특정 사용자 조회");
        return userService.getUserByuserId(userId);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        logger.debug("debug mode : controller : 사용자 등록");
        return userService.registerUser(user);
    }

    @PutMapping("/{userId}")
    public void modifyUSer(@PathVariable("userId") String userId,
                           @RequestBody User user){
<<<<<<< HEAD
        logger.debug("debug mode : controller : 사용자 수정 testing");
=======
        logger.debug("debug mode : controller : 사용자 변경 lake");
>>>>>>> lake
        userService.modifyUer(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable("userId") Integer userId){
        userService.removeUser(userId);
    }


}
