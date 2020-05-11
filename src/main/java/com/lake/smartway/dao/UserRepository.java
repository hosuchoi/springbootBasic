package com.lake.smartway.dao;

import com.lake.smartway.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    public static List<User> users;
    static {
        users = new ArrayList<User>();
        users.add(new User(100,"kim"));
        users.add(new User(200,"choi"));
        users.add(new User(300,"lee"));
        users.add(new User(400,"cho"));
        users.add(new User(500,"park"));
        users.add(new User(600,"sung"));
    }

    public List<User> getUsers() {
        System.out.println("all users!!");
        return users;
    }

    public User getUserByuserId(Integer userId) {
        System.out.println("User by userId!!");

        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(new User(0, "no user"));
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public void updateUser(String userId, User user) {

         users.stream()
                .filter(findUser -> findUser.getUserId().equals(user.getUserId()))
                .findAny()
                .orElse(new User( 0,"no user"))
                 .setUserName(user.getUserName());

    }

    public void deleteUser(Integer userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }

    public Map<String, String> getMessage(){
        Map<String,String> res = new HashMap<>();
        return res;
    }
}
