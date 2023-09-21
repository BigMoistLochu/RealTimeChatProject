package com.example.realtimechatproject.restControllers;

import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.services.restControllersServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserRestController {

    private UserService userService;


    @GetMapping("/all/users")
    public List<User> getAllUsers()
    {
        return userService.getListOfUsers();
    }

    //    @RequestParam(value="id", required="false") Long id uzywamy gdy nie chcemy zeby obowiazkiem
    //    bylo podanie argumentu id, w tym przypadku domyslnie jest required na true
    @DeleteMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long userId)
    {
        userService.deleteUserById(userId);
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
    {
//        ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
        return ResponseEntity.of(userService.getUserById(userId));
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        //Co chcesz zwrocic do klienta? jaki status?
        //Co w przypadku gdzie user juz istnieje?
        //co w przypadku gdy podasz zle wartosci?
        System.out.println(user.toString());
        userService.addUser(user);
        //tylko ze on nie zostanie wyslany do klienta,zostanie rzucony wyjatke w aplikacji
        //jesli bysmy chcieli zwrocic
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
