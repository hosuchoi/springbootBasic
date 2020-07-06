package com.lake.smartway.jwt.service;

public interface SecurityService {
        public String createToken(String subject, long ttlmillits);
        public String getSubejct(String token);
}
