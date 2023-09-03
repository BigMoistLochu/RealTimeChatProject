package com.example.realtimechatproject.restControllers;

import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserRestController {

    private UserService userService;


    @GetMapping("/all/users")
    public List<UserEntity> getAllUsers()
    {
        return userService.getListOfUsers();
    }
}
