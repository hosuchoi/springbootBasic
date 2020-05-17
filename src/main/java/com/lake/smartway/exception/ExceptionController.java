package com.lake.smartway.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/exp")
    public String hello() {
//        int a = 5/0; //500 error 용
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody errorDTO samplerError(SampleException e){
        errorDTO errorDTO = new errorDTO();
        errorDTO.setErrorCode("sampleException");
        errorDTO.setErrorDescription("sampleExceptin throw new runtime");

        return errorDTO;
    }
}
