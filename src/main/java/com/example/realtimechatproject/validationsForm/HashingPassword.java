package com.example.realtimechatproject.validationsForm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword {

    private String password = "haslo123";

    public HashingPassword() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] message = messageDigest.digest(password.getBytes());
        BigInteger bigInteger = new BigInteger(1,message);

        System.out.println(bigInteger.toString(16));

        if(bigInteger.toString(16).equals("75f3af6270ac666850054b12620f7442"))
        {
            System.out.println("poprawne");
        }
    }
}
