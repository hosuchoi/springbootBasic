package com.lake.smartway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@ConfigurationProperties("app")
@Validated //properties에서 들어오는 값에 대한 유효성 체크 ( 아래의 JSR-303 ( @NotEmpty,@size 같은 어노테이션 ) 사용 가능 )
public class ClassProperties {

    @NotEmpty
    private String name;
//    @Size(min=-1,max=1000)
    private int randomValue; // applicationProperties에 값을 자동으로 spring 컨버터가 int 타입을 변환해줌
    private String fullName;

    @DurationUnit(ChronoUnit.SECONDS) // applicationPropeties의 sessionTimeout의 값 뒤에 s를 붙이면 해당 어노테이션 안써도 됨 (동일한 기능)
    private Duration sessionTimeout = Duration.ofSeconds(30); //default value 30

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}