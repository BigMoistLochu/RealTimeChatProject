package com.example.realtimechatproject.repositories;

import com.example.realtimechatproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User getFirstByHaslo(String haslo);

    User getFirstByLogin(String login);
    List<User> getAllByHaslo(String haslo);

    Boolean existsByLogin(String login);

    User getFirstById(Long id);

    User getFirstBySurname(String surname);
    List<User> getAllBySurname(String surname);

    Boolean existsByToken(String token);

    User getFirstByToken(String token);
}
