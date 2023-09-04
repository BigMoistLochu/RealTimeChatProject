package com.example.realtimechatproject.repositories;

import com.example.realtimechatproject.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity getFirstByHaslo(String haslo);
    List<UserEntity> getAllByHaslo(String haslo);
    UserEntity getFirstById(Long id);

    UserEntity getFirstBySurname(String surname);
    List<UserEntity> getAllBySurname(String surname);
}
