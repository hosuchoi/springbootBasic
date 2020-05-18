package com.lake.smartway.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
//Json 테스트 ( 어떤 형태로 in / out 되는지 확인 가능 )
//@JsonTest
//특정 부분만 Slice해서 단위 테스트 ( Web과 관련된 bean들만 의존성 생성)
@WebMvcTest(SliceTestController.class)
public class SliceTestControllerTest {
    
//    @JsonTest용 빈 객체
//    @Autowired
//    JacksonTester<SampleDTO> jacksonTester;

//    캡쳐기능
    @Rule
    public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        when(mockSampleService.getName()).thenReturn("lakepool");

        mockMvc.perform(get("/helloSlice"))
                .andExpect(content().string("hello lakepool"));

        assertThat(outputCaptureRule.toString())
                .contains("lakeman")
                .contains("skip");
    }
}