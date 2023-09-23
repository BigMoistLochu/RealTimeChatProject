package com.example.realtimechatproject.services.restControllersServices;

import com.example.realtimechatproject.exeptions.LengthException;
import com.example.realtimechatproject.models.User;
import com.example.realtimechatproject.repositories.UserRepository;
import lombok.AllArgsConstructor;
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

    public void addUser(User user)
    {
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getSurname());
        userEntity.setLogin(user.getLogin());
        userEntity.setHaslo(user.getHaslo());
        userEntity.setToken(user.getToken());
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
