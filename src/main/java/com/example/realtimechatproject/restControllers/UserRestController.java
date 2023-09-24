package com.example.realtimechatproject.restControllers;

import com.example.realtimechatproject.exeptions.LengthException;
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
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long userId)
    {
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
    {
//        ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
        return ResponseEntity.of(userService.getUserById(userId));
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody User user){

        if(user.getName().length()>10 || user.getSurname().length()>10)
        {
            throw new LengthException("Za dluga nazwa");
        }
        //mozesz zwalidowac to co przyszlo i wywalac odpowiednie wyjatki jesli cos pojdzie nie tak
        //mozesz zrobic to w tej klasie, a mozesz to podzieli

        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
