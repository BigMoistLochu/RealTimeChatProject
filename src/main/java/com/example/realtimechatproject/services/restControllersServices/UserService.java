package com.example.realtimechatproject.services.restControllersServices;

import com.example.realtimechatproject.exeptions.HashingException;
import com.example.realtimechatproject.exeptions.LengthException;
import com.example.realtimechatproject.models.ChatMessage;
import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.repositories.UserRepository;
import com.example.realtimechatproject.validations.HashingEmail;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public List<User> getListOfUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    public void addUser(User user) {

        if(user.getName().length()>20 || user.getSurname().length()>20)
            throw new LengthException("Za dluga nazwa");

        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getSurname());
        userEntity.setLogin(user.getLogin());
        userEntity.setHaslo(user.getHaslo());

        String temporaryToken = HashingEmail.GenereteNewToken(user.getLogin());

        userEntity.setToken(temporaryToken);
        userRepository.save(userEntity);
    }

    public void deleteUserById(Long id)
    {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Long id)
    {
       return userRepository.findById(id);
    }

    public User getUserByLogin(String login)
    {
        return userRepository.getFirstByLogin(login);
    }

    public Boolean isUserExists(String login)
    {
        return userRepository.existsByLogin(login);
    }

    public Boolean isTokenExists(String token)
    {
        return userRepository.existsByToken(token);
    }

    public User getUserByToken(String token)
    {
        return userRepository.getFirstByToken(token);
    }




}
