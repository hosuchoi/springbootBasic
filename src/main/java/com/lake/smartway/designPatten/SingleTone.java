package com.lake.smartway.designPatten;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SingleTone {
    private SingleTone() {}

    public static ObjectMapper getInstance() {
        return Mapper.INSTANCE;
    }

    private static class Mapper {
        private static final ObjectMapper INSTANCE = new ObjectMapper();
    }
}