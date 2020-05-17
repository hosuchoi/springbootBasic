package com.lake.smartway.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RamdomPortTestControllerTest {

/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
RANDOM_PORT는 사용하지 않는 랜덤 port로 실제 Servlet이 구동된다.
그래서 MockMVC를 쓰는게 아니고 TestRestTemplate나 TestWebClient를 사용해야함
 */
    
/*
 1) TestRestTemplate 사용 방법
 */
    @Autowired
    TestRestTemplate testRestTemplate;

    //특정 시점까지만 테스트 하고 싶을때 (Controller만 테스트 하고 싶을때)
    // 해당 Mock에서 강제로 return
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception{
        //Mocking
        when(mockSampleService.getName()).thenReturn("lakepool");

        String result = testRestTemplate.getForObject("/helloRamdom", String.class);
        assertThat(result).isEqualTo("hello lakepool");
    }

/*
 2) WebTestClient 사용 방법 (추천)
 */
    // webTestClient를 사용하기 위해서는 spring5에서 추가된 webflux의존성 추가해야함
    // webTestClient는 async(비동기)라서 속도가 빠름
//의존성 추가해야함
//      <dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-webflux</artifactId>
//		</dependency>
    @Autowired
    WebTestClient webTestClient;

    @Test
    public void helloWeb() throws Exception{
        when(mockSampleService.getName()).thenReturn("lakepool");

        webTestClient.get().uri("/helloRamdom").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello lakepool");
    }
}

