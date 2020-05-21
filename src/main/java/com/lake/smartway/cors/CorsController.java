package com.lake.smartway.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*

 Single-Origin Policy (SOP) : 같은 origin에만 요청을 보낼수 있다
 Cross-Orgin Resource Sharing (CORS) : 서로 다른 origin끼리 Resource를 공유할수 있게 제공해주는 표준기술
 Origin ?  (ex - http://hostname:8080)
  - URI 스키마 (HTTP, HTTPS)
  - hostname
  - 포트 (8080,18080)
 */

// 여기에 정의시 해당 Controller를 모두 허용하겠다.
//    @CrossOrigin(origins = "http://localhost:18080")
@RestController
public class CorsController {

    // 여기에 정의시 해당 메서드에만 허용 하겠다.
//    @CrossOrigin(origins = "http://localhost:18080")
    @GetMapping("/cors")
    public String cors(){
        return "cors";
    }
}

/*
   여러 Controller를 허용하기 위해서는 Web관련 설정파일에서 (<< WebMvcConfigurer 상속 받은 configration 파일 : WebConfig.java)
    spring mvc 기능을 모두 사용하면서 추가로 registry 등록 가능 ( << CORS 관련 설정은 addCorsMapping을 사용하면 됨)
    WebConfig.java 파일 가서 보셈 ~~~ 이동 ㄱㄱ
 */
