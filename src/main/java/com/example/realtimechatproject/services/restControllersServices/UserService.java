package com.example.realtimechatproject.services.restControllersServices;

import com.example.realtimechatproject.models.UserEntity;
import com.example.realtimechatproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



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
        userRepository.save(userEntity);
    }

}
