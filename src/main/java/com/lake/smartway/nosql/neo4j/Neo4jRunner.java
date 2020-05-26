//package com.lake.smartway.nosql.neo4j;
//
//import org.neo4j.ogm.session.Session;
//import org.neo4j.ogm.session.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Neo4jRunner implements ApplicationRunner {
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Autowired
//    Neo4jAccountRepository neo4jAccountRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        /*
//        SessionFactory 방식
//         */
//        Neo4jAccount neo4jAccount = new Neo4jAccount();
//        neo4jAccount.setUsername("lake");
//        neo4jAccount.setEmail("lake1310@naver.com");
//
//        /*
//          Neo4jAccount와 Neo4jRole 관계를 맺음
//         */
//        Neo4jRole neo4jRole = new Neo4jRole();
//        neo4jRole.setName("admin");
//
//        neo4jAccount.getRoles().add(neo4jRole);
//
//        Session session = sessionFactory.openSession();
//        session.save(neo4jAccount);
////        session.clear(); // 해당 session의 캐시정보들을 삭제하는거 같음?
//        sessionFactory.close(); //close 안하면 어플리케이션 안죽음....
//
//
//        /*
//        Neo4jRepository 방식
//         */
//        neo4jAccount.setUsername("lake2");
//        neo4jAccount.setEmail("lake13102@naver.com");
//
//        /*
//          Neo4jAccount와 Neo4jRole 관계를 맺음
//         */
//        Neo4jRole neo4jRole2 = new Neo4jRole();
//        neo4jRole.setName("admin2");
//
//        neo4jAccount.getRoles().add(neo4jRole2);
//        neo4jAccountRepository.save(neo4jAccount);
//    }
//}
