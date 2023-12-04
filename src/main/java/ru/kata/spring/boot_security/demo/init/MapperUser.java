package ru.kata.spring.boot_security.demo.init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entities.User;

@Component
public class MapperUser {


    public UserDTO userToUserDTO(User user){
        System.out.println("Ввнутри метода  public UserDTO userToUserDTO(User user){");
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        System.out.println("Перед ретерном метда public UserDTO userToUserDTO(User user){");
        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        return user;

    }

}
