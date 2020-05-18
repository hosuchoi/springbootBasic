package com.lake.smartway.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SecurityCotroller.class)
public class SecurityCotrollerTest {

    @Autowired
    MockMvc mockMvc;
    /*
     @WithMockUser 가짜유저인증정보사용 의존성 추가 필요
    <dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<version>${spring-security.version}</version>
			<scope>test</scope>
		</dependency>
     */

    @Test
    @WithMockUser
    public void hello() throws Exception {
        //accept header를 지정 안하면 basic autentication으로 요청함
        //accept header를 txt/html으로 하면 form autentication으로 요청함
        mockMvc.perform(get("/secu").accept(MediaType.TEXT_HTML))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("secu"));
    }

    @Test
    public void hello_without_user() throws Exception {
        mockMvc.perform(get("/secu"))
                .andDo(print())
                .andExpect(status().isUnauthorized());  // 401 - unauthorized 예상 (인증 처리 에러 확인)
    }

    @Test
    @WithMockUser
    public void my() throws Exception {
        mockMvc.perform(get("/my"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("my"));
    }
}