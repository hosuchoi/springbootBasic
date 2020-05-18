package com.lake.smartway.serialized;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Base64;

/*
직렬화 대상이 된 객체의 클래스가 클래스 패스에 존재해야 하며 import 되어 있어야 합니다.
중요한 점은 직렬화와 역직렬화를 진행하는 시스템이 서로 다를 수 있다는 것을 반드시 고려해야 합니다.

*SUID  : private static final long serialVersionUID = 1L;
자바 직렬화 대상 객체는 동일한 serialVersionUID 를 가지고 있어야 합니다.
SUID(serialVersionUID) 필수 값은 아니다.
호환 가능한 클래스는 SUID값이 고정되어 있다.
SUID가 선언되어 있지 않으면 클래스의 기본 해쉬값을 사용한다. (해쉬값 알고리즘은 링크에서 확인이 가능합니다.)
serialVersionUID의 값이 동일하면 멤버 변수 및 메서드 추가는 크게 문제가 없습니다.
그리고 멤버 변수 제거 및 이름 변경은 오류는 발생하지 않지만 데이터는 누락됩니다.
 */
@RestController
public class ObjectSerialized {

    Logger logger = LoggerFactory.getLogger(ObjectSerialized.class);

    @GetMapping("/serialized")
    public String test() throws IOException, ClassNotFoundException {
        Member member = new Member("최호수", "lake1310@naver.com", 20);

        /*
        직렬화
         */
        byte[] serializedMember;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput oos = new ObjectOutputStream(baos);
        oos.writeObject(member);
        //serializedMember -> 직렬화된 member 객체
        serializedMember = baos.toByteArray();
        //바이트 배열로 생성된 직렬화 데이터를 base64로 변환
        logger.debug("Java Serialized : "+serializedMember);
        String encodeMember = Base64.getEncoder().encodeToString(serializedMember);
        logger.debug("Java Serialized Base64 endcoding : "+encodeMember);

        /*
        역직렬화
         */
        byte[] unSerializedMember = Base64.getDecoder().decode(encodeMember);
        logger.debug("Java Serialized Base64 decoding : "+ unSerializedMember);
        //직렬화되어 있는 바이트데이터를 역직렬화 -> Member 객체
        ByteArrayInputStream bais = new ByteArrayInputStream(unSerializedMember);
        ObjectInputStream ois = new ObjectInputStream(bais);
        //역직렬화된 Member 객체를 읽어 온다
        Object objectMember = ois.readObject();
        Member m = (Member)objectMember;
        logger.debug("Java Unserialized : "+ m.toString());

        /*
        문자열 형태로 직열화 하기 : CVS
         */
        String csv = String.format("%s,%s,%d",member.getName(), member.getEmail(), member.getAge());
        logger.debug("CSV Serialized : " + csv);

        /*
        문자열 형태로 직열화 하기 : JSON
         */
        String json = String.format(
                "{\"name\":\"%s\",\"email\":\"%s\",\"age\":%d}",
                member.getName(), member.getEmail(), member.getAge());
        logger.debug("Json Serialized : "+ json);

        //JONS Byte size : json.getBytes("utf-8").length

        return "complate";
    }
}
