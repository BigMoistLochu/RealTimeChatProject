package com.example.realtimechatproject.validationsForm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword {

    private String password;
    private BigInteger bigInteger;

    public HashingPassword(String password) throws NoSuchAlgorithmException {

        if(password.length()==0)
        {
            throw new NumberFormatException();
        }

        bigInteger = new BigInteger(1,MessageDigest.getInstance("MD5").digest(password.getBytes()));
    }



    public String getHashedPassword()
    {
        return bigInteger.toString(16);
    }

}
