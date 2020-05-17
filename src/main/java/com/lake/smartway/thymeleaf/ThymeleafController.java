package com.lake.smartway.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

// @RestController에서는 String return시 response로 인식
// @Controller에서는 String return시 템플릿 view 명으로 인식
//  (템플릿 뷰 : FreeMarker, Groovy, Thymeleaf, Mustanche)
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/test")
    public String thymeleafTest(Model model){
        model.addAttribute("name","lake");
        return "thymeleafView";
    }
}
