package com.example.realtimechatproject;

import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealTimeChatProjectApplication implements CommandLineRunner {

    UserRepository userRepository;
    public RealTimeChatProjectApplication(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(RealTimeChatProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        UserEntity entity1 = new UserEntity("47@wp.pl","4744","mati1");
        userRepository.save(entity1);
        System.out.println(userRepository.findAll());

    }
}
