package com.example.realtimechatproject.services.restControllersServices;

import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public List<UserEntity> getListOfUsers()
    {
        return (List<UserEntity>) userRepository.findAll();
    }

    public void addUser(UserEntity user)
    {
        UserEntity userEntity = new UserEntity();
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

    public UserEntity getUserById(Long id)
    {
       return userRepository.getFirstById(id);
    }

    public UserEntity getUserByLogin(String login)
    {
        return userRepository.getFirstByLogin(login);
    }

    public Boolean isUserExists(String login)
    {
        return userRepository.existsByLogin(login);
    }

}
