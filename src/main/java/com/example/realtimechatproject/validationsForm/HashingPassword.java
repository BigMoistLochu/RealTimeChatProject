package com.example.realtimechatproject.validationsForm;

import lombok.extern.slf4j.Slf4j;
import java.math.BigInteger;
import java.security.MessageDigest;



@Slf4j
public class HashingPassword {

    private String password;
    private BigInteger bigInteger;




    public HashingPassword(String password){

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
            log.info("problem in:" + getClass() + "in constructor");
        }


    }



    public String getHashedPassword()
    {
        return bigInteger.toString(16);
    }

}
