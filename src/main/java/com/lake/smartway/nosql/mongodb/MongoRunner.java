//package com.lake.smartway.nosql.mongodb;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MongoRunner implements ApplicationRunner {
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Autowired
//    MongoAccountRepository mongoAccountRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        /*
//        MongoTemplate 방식
//         */
//        MongoAccount mongoAccount = new MongoAccount();
//        mongoAccount.setEmail("lake@naver.com");
//        mongoAccount.setUsername("lake");
//
//        mongoTemplate.insert(mongoAccount);
//        System.out.println("finished");
//
//        /*
//        MongoRepository 방식식
//         */
//        mongoAccount.setEmail("lake2@naver.com");
//        mongoAccount.setUsername("lake2");
//        mongoAccountRepository.insert(mongoAccount);
//        System.out.println("finished");
//   }
//}
