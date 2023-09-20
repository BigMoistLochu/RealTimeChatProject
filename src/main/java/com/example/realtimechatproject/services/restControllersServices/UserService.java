package com.example.realtimechatproject.services.restControllersServices;

import com.example.realtimechatproject.exeptions.LengthException;
import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

        if(user.getName().length()>20)
        {
            throw new LengthException("Za dlugi Nejm");
        }
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

    public Optional<UserEntity> getUserById(Long id)
    {
       return userRepository.findById(id);
    }

    public UserEntity getUserByLogin(String login)
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

    public UserEntity getUserByToken(String token)
    {
        return userRepository.getFirstByToken(token);
    }

}
