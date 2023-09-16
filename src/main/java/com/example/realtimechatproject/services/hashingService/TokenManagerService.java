package com.example.realtimechatproject.services.hashingService;

import com.example.realtimechatproject.validationsForm.HashingEmail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class TokenManagerService {

    private HashingEmail hashingEmail;


    public String GenerateNewToken(String email) throws NoSuchAlgorithmException {

        return hashingEmail.HashTheEmail(email);
    }

    public boolean CheckToken(String password,String token) throws NoSuchAlgorithmException {
        if(GenerateNewToken(password).equals(token))
        {
            return true;
        }
        return false;
    }



}
