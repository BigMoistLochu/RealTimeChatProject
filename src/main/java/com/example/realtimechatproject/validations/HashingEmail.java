package com.example.realtimechatproject.validations;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.example.realtimechatproject.exeptions.HashingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class HashingEmail{

    private HashingEmail(){}

    public static String GenereteNewToken(String password){
        Logger logger = LoggerFactory.getLogger(HashingEmail.class);
        try {
           String hashThePassword = new BigInteger(1, MessageDigest.getInstance("MD5").
                    digest(password.getBytes())).toString(16);
            return hashThePassword;
        } catch (Exception e) {
            logger.info("Błąd podczas hashowania Emaila",e.getMessage());
            throw new HashingException("Token Generation error");
        }
    }

}
