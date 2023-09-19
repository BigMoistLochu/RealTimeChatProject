package com.example.realtimechatproject.repositories;

import com.example.realtimechatproject.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity getFirstByHaslo(String haslo);

    UserEntity getFirstByLogin(String login);
    List<UserEntity> getAllByHaslo(String haslo);

    Boolean existsByLogin(String login);

    UserEntity getFirstById(Long id);

    UserEntity getFirstBySurname(String surname);
    List<UserEntity> getAllBySurname(String surname);

    Boolean existsByToken(String token);

    UserEntity getFirstByToken(String token);
}
