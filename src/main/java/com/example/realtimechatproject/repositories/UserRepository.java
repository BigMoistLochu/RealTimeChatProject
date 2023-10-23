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

    boolean existsByLogin(String login);

    User getFirstById(Long id);

    User getFirstBySurname(String surname);
    List<User> getAllBySurname(String surname);

    boolean existsByToken(String token);

    User getFirstByToken(String token);

    User getFirstBySurnameAndName(String surname,String name);

    User getFirstByLoginAndHaslo(String login,String haslo);
    boolean existsByLoginAndHaslo(String login,String haslo);
}
