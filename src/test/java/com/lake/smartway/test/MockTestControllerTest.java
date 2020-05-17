package com.lake.smartway.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest는 실제 application을 호출하여서 모든 bean을 다 등록함 ( 통합 테스트 )
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MockTestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello lake"))
                .andDo(print());
    }
}

/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
실제 servlet 컨테이너를 띄우지 않고 servlet을 Mocking한것이 뜬다.
dispatcherservlet을 뜨긴 하지만 해당 servlet을 사용하려면 MockMvc 클라이언트를 사용해야함
-> 그래서 @AutoConfigureMockMvc 추가

print() 찍힌 내용
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /hello
       Parameters = {}
          Headers = []
             Body = null
    Session Attrs = {}

Handler:
             Type = com.lake.smartway.test.MockTestController
           Method = com.lake.smartway.test.MockTestController#hello()

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"10"]
     Content type = text/plain;charset=UTF-8
             Body = hello lake
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
2020-05-17 15:13:27.864  INFO 41256 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
Disconnected from the target VM, address: '127.0.0.1:3515', transport: 'socket'

Process finished with exit code 0
 */