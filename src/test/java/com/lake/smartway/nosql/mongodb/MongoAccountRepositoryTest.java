//package com.lake.smartway.nosql.mongodb;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataMongoTest // MongoDB slice test
//public class MongoAccountRepositoryTest {
//
//    @Autowired
//    MongoAccountRepository mongoAccountRepository;
//
//    @Test
//    public void findByEmail(){
//        MongoAccount mongoAccount = new MongoAccount();
//        mongoAccount.setUsername("lake");
//        mongoAccount.setEmail("lake1310@naver.com");
//
//        mongoAccountRepository.save(mongoAccount);
//
//        mongoAccountRepository.findById(mongoAccount.getId());
//        Optional<MongoAccount> byUsername =  mongoAccountRepository.findByUsername(mongoAccount.getUsername());
//        assertThat(byUsername).isNotEmpty();
//
//        Optional<MongoAccount> byEmail = mongoAccountRepository.findByEmail(mongoAccount.getEmail());
//        assertThat(byEmail).isNotEmpty();
//        assertThat(byEmail.get().getUsername()).isEqualTo("lake");
//    }
//}