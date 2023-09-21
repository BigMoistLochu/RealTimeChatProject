package com.example.realtimechatproject.services.hashingService;

import com.example.realtimechatproject.services.restControllersServices.UserService;
import com.example.realtimechatproject.validations.HashingEmail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class TokenManagerService {

    private HashingEmail hashingEmail;

    private UserService userService;

    //Hash The Email and return token
    public String GenerateNewToken(String email) throws NoSuchAlgorithmException {
        return hashingEmail.HashTheEmail(email);
    }

    //Heck The generated token
    public boolean CheckToken(String password,String token) throws NoSuchAlgorithmException {
        return GenerateNewToken(password).equals(token);
    }









}
