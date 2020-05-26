//package com.lake.smartway.nosql.redis;
//
//import com.lake.smartway.security.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class RedisRunner implements ApplicationRunner {
//
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    RedisAccountRepository redisAccountRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        /*
//        StringRedisTemplate 방식 ( redisTemplate 방식 )
//        */
//        ValueOperations<String, String> values = stringRedisTemplate.opsForValue();
//        values.set("lake","good");
//        values.set("spring","boot");
//        values.set("hello","world");
//
//        /*
//        CrudRepositry 방식
//         */
//        RedisAcount redisAcount = new RedisAcount();
//        redisAcount.setEmail("lake@naver.com");
//        redisAcount.setUsername("lake");
//
//        RedisAcount savedAccount = redisAccountRepository.save(redisAcount);
//        Optional<RedisAcount> byId = redisAccountRepository.findById(savedAccount.getId());
//
//        System.out.println(byId.get().getUsername());
//        System.out.println(byId.get().getEmail());
//    }
//}
