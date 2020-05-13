package com.lake.smartway;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SmartwayApplication {

	public static void main(String[] args) {
		//기본 방식 (static 방식으로 커스텀하게 처리 불가)
//		SpringApplication.run(SmartwayApplication.class, args);

		//커스텀한 처리를 위한 방식
		SpringApplication app = new SpringApplication(SmartwayApplication.class);
//		app.setBannerMode(Banner.Mode.OFF); // 배너 기능 OFF
		app.run(args);

		//빌더 사용 방식go
//		new SpringApplicationBuilder()
//				.sources(SmartwayApplication.class)
//				.run(args);
		System.out.println("aaaa");
		System.out.println("aaaa");
		System.out.println("aaaa");
		System.out.println("aaaa");
	}
}
