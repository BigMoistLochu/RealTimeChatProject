package com.example.realtimechatproject.validationsForm;

import lombok.extern.slf4j.Slf4j;
import java.math.BigInteger;
import java.security.MessageDigest;



@Slf4j
public class HashingPassword {

    private String password;
    private BigInteger bigInteger;


    public HashingPassword(String password){
        this.password = password;
    }

    public void HashThePassword(String password)
    {
        try
        {
            if(password.length()==0)
            {
                throw new NumberFormatException();
            }


            bigInteger = new BigInteger(1,MessageDigest.getInstance("MD5").digest(password.getBytes()));
        }
        catch(Exception e)
        {
            log.info("Length of the password is 0");
        }
    }



    public String getHashedPassword()
    {
        return bigInteger.toString(16);
    }

}
