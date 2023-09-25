package com.example.realtimechatproject.exeptions;

import java.security.NoSuchAlgorithmException;

public class HashingException extends RuntimeException {

    public HashingException(String msg) {
        super(msg);
    }

    public HashingException(String message, Throwable cause) {
        super(message, cause);
    }
}
