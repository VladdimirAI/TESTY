package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.HashMap;
import java.util.Map;


@Repository
public class MapUserRepository {

    private final Map<Long,User> usersMap;

    public MapUserRepository() {
      usersMap = new HashMap<>();
    }

    public User findById(Long id){
       return usersMap.get(id);
    }

    public void save(User user){
        usersMap.put(user.getId(),user);
    }



}
