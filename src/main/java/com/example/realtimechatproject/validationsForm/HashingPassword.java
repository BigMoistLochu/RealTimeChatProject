package com.example.realtimechatproject.validationsForm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword {

    private String password;
    private BigInteger bigInteger;
    private MessageDigest messageDigest;

    public HashingPassword(String password){
        this.password = password;
    }

    public void hashThePassword() throws NoSuchAlgorithmException {
        if(!password.isBlank())
        {
             this.messageDigest= MessageDigest.getInstance("MD5");
            //tutaj juz jest zahashowane
            this.bigInteger = new BigInteger(1,messageDigest.digest(password.getBytes()));
        }
    }

    public String getHashedPassword()
    {
        return bigInteger.toString(16);
    }

}
