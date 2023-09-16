package com.example.realtimechatproject.services.hashingService;

import com.example.realtimechatproject.validationsForm.HashingEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TokenManagerServiceTest {




    @Test
    void generateNewTokenMethodShouldReturnHashedToken() throws NoSuchAlgorithmException {


        String password = "password";
        Assertions.assertThrows(NoSuchAlgorithmException.class,()->MessageDigest.getInstance("MS5").digest(password.getBytes()));
    }



    //public String HashTheEmail(String password) throws NoSuchAlgorithmException {
    //        BigInteger hashThePassword = new BigInteger(1,MessageDigest.getInstance("MD5").
    //                digest(password.getBytes()));
    //        return hashThePassword.toString(16);
    //    }

    @Test
    void checkTokenShouldReturnTrue() throws NoSuchAlgorithmException {

        String expectToken = "2240559ea547577898a9c2f2801ab8bb";

    }

}