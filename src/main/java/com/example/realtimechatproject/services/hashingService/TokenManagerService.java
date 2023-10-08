package com.example.realtimechatproject.services.hashingService;
import com.example.realtimechatproject.validations.HashingEmail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenManagerService {


    //Hash The Email and return token
    public static String GenerateNewToken(String email){
        return HashingEmail.GenereteNewToken(email);
    }



    //Heck The generated token
    public boolean CheckToken(String password,String token){
        return GenerateNewToken(password).equals(token);
    }









}
