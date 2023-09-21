package com.example.realtimechatproject.validations;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
public class HashingEmail{

    public String HashTheEmail(String password) throws NoSuchAlgorithmException {
        BigInteger hashThePassword = new BigInteger(1,MessageDigest.getInstance("MD5").
                digest(password.getBytes()));
        return hashThePassword.toString(16);
    }

}