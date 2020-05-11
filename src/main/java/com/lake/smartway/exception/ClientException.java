package com.lake.smartway.exception;

public class ClientException extends RuntimeException {
    private final int errorCode;
    private final String errorDescription;

    public ClientException(int errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
