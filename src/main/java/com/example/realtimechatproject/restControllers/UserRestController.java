package com.example.realtimechatproject.restControllers;

import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long userId)
    {
        userService.deleteUserById(userId);
    }

    @GetMapping("/user/get/{id}")
    public UserEntity getUserById(@PathVariable("id") Long userId)
    {
        return userService.getUserById(userId);
    }
}
