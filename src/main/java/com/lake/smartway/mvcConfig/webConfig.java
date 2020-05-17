package com.lake.smartway.mvcConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//boot에서 제공하는 모든 기능을 사용 안하고, 재정의해서 쓰겠다!
//모든 기능을 다 재개발해야하므로 특수한 경우외에는 이럴 경우는 없다.
//@EnableWebMvc
public class webConfig implements WebMvcConfigurer {  //WebMvcConfigurer : web mvc의 추가적인 설정을 위한 상속

    //WEB MVC의 정적 리소스 디렉토리 위치 추가해주는 메서드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")
                .setCachePeriod(20);
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
