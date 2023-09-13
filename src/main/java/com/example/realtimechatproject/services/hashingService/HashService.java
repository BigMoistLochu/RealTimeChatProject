package com.example.realtimechatproject.services.hashingService;

import com.example.realtimechatproject.validationsForm.HashingEmail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class HashService {

    private HashingEmail hashingEmail;



    //hashowanie emaila(tworzenie tokenu)
    //przypisywanie tokenu do headera

    public String HashAndGetHashEmail(String email) throws NoSuchAlgorithmException {

        return hashingEmail.HashTheEmail(email);
    }



}
