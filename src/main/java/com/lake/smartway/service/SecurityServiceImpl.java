package com.lake.smartway.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@Service
public class SecurityServiceImpl implements SecurityService{

    private final static String secretKey = "d2143njefn12l3nkflednj213nnkndfn";

    /**
     * JWT 토큰 생성 ( 최초 생성 )
     * @param subject
     * @param ttlmillits
     * @return
     */
    @Override
    public String createToken(String subject, long ttlmillits) {

        if(ttlmillits == 0){
            throw new RuntimeException("해당 토큰이 만료되었습니다.");
        }

        //H256 암호화 방식
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //시큐리티 키로 통해 암호화
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        //H256 암호화 방식과 시큐리티키를 이용한 signing key 생성
        SecretKeySpec signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //JWT 빌더 패턴을 통해서 토큰 생성
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);
        //만료기간 생성
        long nowMillis = System.currentTimeMillis();
        jwtBuilder.setExpiration(new Date(nowMillis + ttlmillits));

        return jwtBuilder.compact();
    }

    /**
     * JWT 토큰 검증 ( client에서 요청할때 넘겨준 jwt token 값 검증 )
     * secret키를 이용한 검증
     * @param token
     * @return
     */
    @Override
    public String getSubejct(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
