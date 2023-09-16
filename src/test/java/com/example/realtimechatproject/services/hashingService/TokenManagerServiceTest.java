package com.example.realtimechatproject.services.hashingService;

import com.example.realtimechatproject.validationsForm.HashingEmail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.security.NoSuchAlgorithmException;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TokenManagerServiceTest {




    @Test
    void generateNewTokenMethodShouldReturnHashedToken() throws NoSuchAlgorithmException {
        HashingEmail hashingEmail = new HashingEmail();
        String fakeToken = hashingEmail.HashTheEmail("Fake Email");
        String expectToken = "2240559ea547577898a9c2f2801ab8bb";
        assertEquals(expectToken,fakeToken);
    }

    @Test
    void checkTokenShouldReturnTrue() throws NoSuchAlgorithmException {

        String expectToken = "2240559ea547577898a9c2f2801ab8bb";

    }

}