package com.lake.smartway.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/*
Hypermedia As The Engine Of Application State
서버: 현재 리소스와 연관된 링크 정보를 클라이언트에게 제공한다.
클라이언트: 연관된 링크 정보를 바탕으로 리소스에 접근한다.
연관된 링크 정보
Relation
Hypertext Reference)
spring-boot-starter-hateoas 의존성 추가
https://spring.io/understanding/HATEOAS
https://spring.io/guides/gs/rest-hateoas/
https://docs.spring.io/spring-hateoas/docs/current/reference/html/
ObjectMapper 제공
spring.jackson.*
Jackson2ObjectMapperBuilder
LinkDiscovers 제공
클라이언트 쪽에서 링크 정보를 Rel 이름으로 찾을때 사용할 수 있는 XPath 확장 클래스
 */

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    public Resource<Hello> hello(){
        Hello hello = new Hello();
        hello.setPrefix("hey, ");
        hello.setName("lake");

        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(HateoasController.class).hello()).withSelfRel());

        return helloResource;
    }
}
