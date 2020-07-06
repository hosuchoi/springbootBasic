package com.lake.smartway.service;

import com.lake.smartway.jwt.dao.UserRepository;
import com.lake.smartway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserByuserId(Integer userId) {
        return userRepository.getUserByuserId(userId);
    }

    public User registerUser(User user) {
        return userRepository.createUser(user);
    }

    public void modifyUer(String userId, User user) {
        userRepository.updateUser(userId, user);
    }

    public void removeUser(Integer userId) {
        userRepository.deleteUser(userId);
    }

    public Map<String, String> getMessage(){
        return userRepository.getMessage();
    }
}
