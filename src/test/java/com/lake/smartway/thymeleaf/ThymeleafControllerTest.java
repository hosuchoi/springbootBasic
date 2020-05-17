package com.lake.smartway.thymeleaf;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ThymeleafController.class)
public class ThymeleafControllerTest {

    /*
    Thymeleaf
     1) thymeleaf 의존성 추가 ( spring-boot-starter-thymeleaf )
     2) html에 xml 네임스페이스 추가 ( xmlns:th="http://www.thymeleaf.org" )
     3) th테그를 이용한 model의 name attribute값을 표현 <h1 th:text="${name}">Name</h1>
     4) @Controller를 통한 view 호출
     */
    @Autowired
    MockMvc mockMvc;

    @Test
    public void thymeleafTest() throws Exception {
        mockMvc.perform(get("/thymeleaf/test"))
                .andExpect(status().isOk())
                .andExpect(view().name("thymeleafView")) // html view 호출명 동일 한가 ?
                .andExpect(model().attribute("name", is("lake"))) // model의 name attribute에 lake 값이냐?
                .andExpect(content().string(containsString("lake"))); // html의 내용에 lake값이 존재하는지 체크
    }

    /*
     HTML UNIT : HTML 적으로 더 다양한 테스트를 위한 방법
     1) htmlunit 의존성 추가 ( htmlunit-driver , htmlunit )
     2) WebClient를 통한 testing 코딩 작성
     3) 다양한 html 분석가능한 api 제공
     */
    @Autowired
    WebClient webClient;

    @Test
    public void htmlUnitTest() throws Exception {
        HtmlPage page = webClient.getPage("/thymeleaf/test");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("lake");
    }
}
