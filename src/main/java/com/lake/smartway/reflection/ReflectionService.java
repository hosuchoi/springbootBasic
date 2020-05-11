package com.lake.smartway.reflection;

//@Service
public class ReflectionService {
    private String key;
    private String value;

    public ReflectionService(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ReflectionService(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
