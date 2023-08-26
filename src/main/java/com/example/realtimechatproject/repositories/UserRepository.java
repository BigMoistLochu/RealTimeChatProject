package com.example.realtimechatproject.repositories;

import com.example.realtimechatproject.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    UserEntity getAllByHaslo();
}
