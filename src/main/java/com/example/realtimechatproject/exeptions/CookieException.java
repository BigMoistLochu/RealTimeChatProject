package com.example.realtimechatproject.exeptions;

public class CookieException extends RuntimeException{

    public CookieException(String message) {
        super(message);
    }

    public CookieException(String message, Throwable cause) {
        super(message, cause);
    }
}
