package com.lake.smartway.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class RestClientRunner implements ApplicationRunner {
    private final Logger logger = LoggerFactory.getLogger(RestClientRunner.class);

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        restClientRun();
        webClientRun();
    }

    //async 동기
    private void restClientRun(){
        logger.debug("=================restClientRun==============================");
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String helloResult = restTemplate.getForObject("http://localhost:8080/restClientHello",String.class);
        logger.debug(helloResult);

        String worldResult = restTemplate.getForObject("http://localhost:8080/restClientWorld",String.class);
        logger.debug(worldResult);

        stopWatch.stop();
        logger.debug(stopWatch.prettyPrint());
    }

    //async 비동기 - 추천 ( 다양하게 빠르게 사용 가능 )
    private void webClientRun(){
        logger.debug("=================webClientRun==============================");
        WebClient webClient = builder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Mono<String> helloMono = webClient.get().uri("http://localhost:8080/restClientHello") //특정 uri에서
                .retrieve() // 결과값을 가져와라
                .bodyToMono(String.class); //mono 타입으로 변경해라
        //subscribe를 해줘야 값을 찍어볼수 있음 - Mono Type 물이 막혀있는 상태 뚫어줘야한다.
        helloMono.subscribe(s -> {
//            logger.debug(s);
            System.out.println(s);

            if(stopWatch.isRunning()){ //비동기라서 어느게 먼저 끝날지 모르므로 런닝중이면 끝내라.
                stopWatch.stop();
            }
//            logger.debug(stopWatch.prettyPrint());
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });

        Mono<String> worldMono = webClient.get().uri("http://localhost:8080/restClientWorld")
                .retrieve()
                .bodyToMono(String.class);
        worldMono.subscribe(s->{
//            logger.debug(s);
            System.out.println(s);

            if(stopWatch.isRunning()){
                stopWatch.stop();
            }
//            logger.debug(stopWatch.prettyPrint());
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });

//        stopWatch.stop();
//        logger.debug(stopWatch.prettyPrint());
    }
}
