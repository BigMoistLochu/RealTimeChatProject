package com.example.realtimechatproject;

import com.example.realtimechatproject.models.ChatMessage;
import com.example.realtimechatproject.models.IForm;
import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.repositories.UserRepository;
import com.example.realtimechatproject.validationsForm.HashingEmail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Scanner;

@SpringBootApplication
public class RealTimeChatProjectApplication implements CommandLineRunner {

//    UserRepository userRepository;
//
//    public RealTimeChatProjectApplication(UserRepository userRepository)
//    {
//        this.userRepository = userRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(RealTimeChatProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//
//        UserEntity entity1 = new UserEntity("4740911@wp.pl","mati1");
//        userRepository.save(entity1);
//        HashingEmail hashingEmail = new HashingEmail();
//        System.out.println(hashingEmail.HashTheEmail("Fake Email"));


        


    }


}


