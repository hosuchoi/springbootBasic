package com.lake.smartway.dao;

import com.lake.smartway.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUsers(){
        List<User> users = userRepository.getUsers();
        Assert.assertTrue( users.size() > 0);
    }

    @Test
    public void testGetUserByUserId() {
        User userByuserId = userRepository.getUserByuserId(100);
        Assert.assertNotNull(userByuserId);
    }
}
