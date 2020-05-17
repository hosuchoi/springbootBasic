package com.lake.smartway;

import com.lake.smartway.applicationListener.StartingEventListener;
import com.lake.smartway.properties.ClassProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
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
		app.setWebApplicationType(WebApplicationType.NONE);


		app.run(args);

		//빌더 사용 방식go
//		new SpringApplicationBuilder()
//				.sources(SmartwayApplication.class)
//				.run(args);

	}
}
