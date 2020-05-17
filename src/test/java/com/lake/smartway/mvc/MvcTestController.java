package com.lake.smartway.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MvcController.class)
public class MvcTestController {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        mockMvc.perform((get("/hello")))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUSer_JSON() throws Exception {
        String userJson = "{\"username\":\"lake\",\"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON) //json 타입으로 보낼거고
                .accept(MediaType.APPLICATION_JSON) //json 타입으로 리턴을 원한다
                .content(userJson)) //실제 body
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username", is(equalTo("lake"))))
                    .andExpect(jsonPath("$.password", is(equalTo("123"))));
    }

    /*
     org.springframework.web.HttpMediaTypeNotAcceptableException
     xml 메세징 컨버터가 없어서 위에 exception 에러 발생
     view Resolve xml 관련 의존성 추가 필요
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
		</dependency>
     */
    @Test
    public void createUSer_XML() throws Exception {
        String userJson = "{\"username\":\"lake\",\"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON) //json 타입으로 보낼거고
                .accept(MediaType.APPLICATION_XML) //xml 타입으로 리턴을 원한다
                .content(userJson)) //실제 body
//                .andDo(print())  // 에러시 자동으로 보여주고 정상일때는 생략됨
                    .andExpect(status().isOk())
                    .andExpect(xpath("/User/username").string("lake"))
                    .andExpect(xpath("/User/password").string("123"));
    }
}
