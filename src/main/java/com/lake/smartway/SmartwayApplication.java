package com.lake.smartway;

import com.lake.smartway.applicationListener.StartingEventListener;
import com.lake.smartway.properties.ClassProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAdminServer // Actuator : Springboot boot admin
//@EnableConfigurationProperties(ClassProperties.class)  // 자동으로 됨
public class SmartwayApplication {

	public static void main(String[] args) {
		//기본 방식 (static 방식으로 커스텀하게 처리 불가)
//		SpringApplication.run(SmartwayApplication.class, args);

		//커스텀한 처리를 위한 방식
		SpringApplication app = new SpringApplication(SmartwayApplication.class);
//		app.setBannerMode(Banner.Mode.OFF); // 배너 기능 OFF
		app.addListeners(new StartingEventListener()); // ApplicationStartingEvent는 직접 등록해서 사용해야됨 ( context가 등록되기 전에 호출되기 때문에 )
		/*
		WebApplicationType.SERVLET : Servlet web MVC가 있는 경우
		WebApplicationType.REACTIVE : spring webflux가 있는 경우
		WebApplicationType.NONE : 둘다 없는 경우
		 * servelt / webflux 둘다 있으면 SERVLET이 설정됨
		 */
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);

		//빌더 사용 방식go
//		new SpringApplicgitationBuilder()
//				.sources(SmartwayApplication.class)
//				.run(args);

	}

//	@Bean
//	public ApplicationRunner applicationRunner(){
//		return new ApplicationRunner() {
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//
//			}
//		};
//	}

//	//모든 web client 빌더는 아래의 custome된 객체를 사용해서 씀 (RestClientRunner.java 참조)
//	@Bean
//	public WebClientCustomizer webClientCustomizer(){
//		return  new WebClientCustomizer() {
//			@Override
//			public void customize(WebClient.Builder webClientBuilder) {
//				webClientBuilder.baseUrl("http://localhost:8080");
//			}
//		};
//	}
//
//	//RestTemplate 커스텀 (의존성 추가 필요)
//	@Bean
//	public RestTemplateCustomizer restTemplateCustomizer(){
//		return new RestTemplateCustomizer() {
//			@Override
//			public void customize(RestTemplate restTemplate) {
//				//아파치 http client 사용 ( 이제 java net http 사용 안함. )
//				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//			}
//		};
//	}
}
