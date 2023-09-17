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
    void generateNewTokenMethodShouldThrowsNoSuchAlgoritmException() throws NoSuchAlgorithmException {

        String password = "RandomPassword";
        Assertions.assertThrows(NoSuchAlgorithmException.class,()->MessageDigest.getInstance("BadAlgo").digest(password.getBytes()));
    }



    @Test
    void checkTokenWchichShouldReturnTrueIfHashedIsCorrect() throws NoSuchAlgorithmException {
        //Given
        HashingEmail hashingEmail = new HashingEmail();
        String expectToken = "2240559ea547577898a9c2f2801ab8bb";
        String passwordToHash = "Fake Email";
        //when
        //then
        assertEquals(expectToken,hashingEmail.HashTheEmail(passwordToHash));
    }

}