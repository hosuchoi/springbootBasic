package com.lake.smartway.mvcConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/*
@EnableWebMvc 설정하게 되면........
boot에서 제공하는 모든 기능을 사용 안하고, 재정의해서 쓰겠다!
모든 기능을 다 재개발해야하므로 특수한 경우외에는 이럴 경우는 없다.
 */
//@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer {  //WebMvcConfigurer : web mvc의 추가적인 설정을 위한 상속

    //WEB MVC의 정적 리소스 디렉토리 위치 추가해주는 메서드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")
                .setCachePeriod(20);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //Controller 생성후 Getmapping "/hello" 와 동일
        //단순 View 호출인 경우에는 이걸 써도 됨(파라미터및 로직이 없는 경우)
//        registry.addViewController("/hello").setViewName("hello");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS 관련한 Mapping 기능 등록 가능 : 글로벌한 설정 가능
//        registry.addMapping("/**")  // 모든 요청에 대해서 설정시
        registry.addMapping("/cors")  // cors 요청에 대해서만 설정시
                .allowedOrigins("http://localhost:18080"); // << 해당 Origin은 허용 하겠다.

    }

    //아래 기능들 추가가능
//    default void configurePathMatch(PathMatchConfigurer configurer) {
//    }
//
//    default void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    }
//
//    default void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//    }
//
//    default void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//    }
//
//    default void addFormatters(FormatterRegistry registry) {
//    }
//
//    default void addInterceptors(InterceptorRegistry registry) {
//    }
//
//    default void addResourceHandlers(ResourceHandlerRegistry registry) {
//    }
//
//    default void addCorsMappings(CorsRegistry registry) {
//    }
//
//    default void addViewControllers(ViewControllerRegistry registry) {
//    }
//
//    default void configureViewResolvers(ViewResolverRegistry registry) {
//    }
//
//    default void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//    }
//
//    default void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
//    }
//
//    default void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    }
//
//    default void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//    }
//
//    default void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//    }
//
//    default void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//    }
}
