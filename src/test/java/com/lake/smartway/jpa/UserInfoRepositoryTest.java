package com.lake.smartway.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest // Slice Test : 단위 테스트를 위한 어노테이션 ( 인메모리 DB 접속만 가능 - H2 의존성 추가 필요 ) << Test 할 경우에는 추천 ( 더 빠르고, 실제 애플리케이션 db는 안거드림 )
//@SpringBootTest // Main Test : 통합 테스트 - 메인 어플리케이션 찾아서 실행 - 애플리케이션 모든 Bean 설정 다함, 애플리케이션에서 사용하는 db 접속됨 (여기선 postgre)
public class UserInfoRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Test
    public void di() throws Exception{
        try(Connection connection = dataSource.getConnection();){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }

        UserInfoDVO userInfoDVO = new UserInfoDVO();
        userInfoDVO.setUsername("lake");
        userInfoDVO.setPassword("pass");

        UserInfoDVO newUserInfoDVO = userInfoRepository.save(userInfoDVO);

        assertThat(newUserInfoDVO).isNotNull();

        Optional<UserInfoDVO> opUserInfoDVO = userInfoRepository.findByUsername(newUserInfoDVO.getUsername());
        assertThat(opUserInfoDVO).isNotEmpty();

        Optional<UserInfoDVO> opNotExistingUserInfoDVO = userInfoRepository.findByUsername(newUserInfoDVO.getUsername());
        assertThat(opNotExistingUserInfoDVO).isEmpty();
    }
}