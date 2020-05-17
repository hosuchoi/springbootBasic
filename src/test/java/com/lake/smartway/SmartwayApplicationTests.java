package com.lake.smartway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:/test.properties") // TestPropertySource 어노테이션 방식이 test/java/... 방식보다 우선순위가 높음
@SpringBootTest
public class SmartwayApplicationTests {

	@Autowired
	Environment environment;

	@Test
	public void contextLoads() {
		assertThat(environment.getProperty("app.name"))
				.isEqualTo("lake study test"); // << test/java/... 에있는 resources/application.properties 파일을 봄 ( 우선순위가 main/java 보다 더 높음 )
		assertThat(environment.getProperty("app.full.name"))
				.isEqualTo("lake study test group"); // << test/java/... 에있는 resources/application.properties 파일을 봄 ( 우선순위가 main/java 보다 더 높음 )
		assertThat(environment.getProperty("test.pro.value"))
				.isEqualTo("test properties value"); // << test.properties 파일 읽어옴
		System.out.println(environment.getProperty("app.random.value"));
	}
}
