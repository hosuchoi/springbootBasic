package com.lake.smartway.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/*
# H2 Console 기능을 사용 ( http://localhost:8080/h2-console )
spring.h2.console.enabled=true
 */

//@Component
public class H2InmemoryRunner implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(H2InmemoryRunner.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // java8 이렇게 try{}를 처리하면 {}안에서 문제가 생기든 정상이든 관련된 내용을 정리해줌
        // connection.close 생략 가능
        try (Connection connection = dataSource.getConnection()) {
            logger.debug("============ H2 인메모리(H2InmemoryRunner.java) ================");
            logger.debug(connection.getMetaData().getURL());
            logger.debug(connection.getMetaData().getUserName());
            logger.debug("=========================+=====================================");

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE INMEMORY_USER_TEST(ID INTEGER NOT NULL, NAME VARCHAR (255), PRIMARY KEY (ID))";
            statement.executeUpdate(sql);
//            connection.close();
        }

        /*
            JdbcTemplate를 사용하면 간편하다!!! (위의 datasourc로 처리햇던 로직 불필요)
             - 커넥션을 알아서 해줌
             - 커넥션 반납도 알아서 해줌
             - 안전하게 처리 가능 (try~catch 알아서 해줌)
             - 예외를 던질때 가독성이 높은 error 메세지를 넘겨줌
         */
        jdbcTemplate.execute("INSERT INTO INMEMORY_USER_TEST VALUES (1,'LAKE')");
    }
}
