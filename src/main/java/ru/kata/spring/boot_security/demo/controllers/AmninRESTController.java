package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.init.MapperUser;
import ru.kata.spring.boot_security.demo.init.UserMapper;
import ru.kata.spring.boot_security.demo.services.UserService;

@RestController
@RequestMapping("/tests")
public class AmninRESTController {

    UserService userService;
    UserMapper userMapper; // Убираем аннотацию Autowired и final не нужен
//      MapperUser userMapper;

    public AmninRESTController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

//
//    public AmninRESTController(UserService userService, MapperUser userMapper) {
//        this.userService = userService;
//        this.userMapper = userMapper;
//    }

    @GetMapping("/{name}")
    public UserDTO getUserByName(@PathVariable("name") String userName) {
        System.out.println("Начался вызов userService.findByUsername(userName);");
        final User user = userService.findByUsername(userName);
        System.out.println("Завершился вызов userService.findByUsername(userName);");
        System.out.println("Начался вызов userMapper.userToUserDTO(user);");
        UserDTO userDTO = userMapper.userToUserDTO(user);
        System.out.println("Завершиля вызов userMapper.userToUserDTO(user);");
        return userDTO;
    }


    @PutMapping()
    public void saveUserNoRole(@RequestBody @Validated UserDTO userDTO) {
        final User user = userMapper.userDTOToUser(userDTO);
        userService.save(user);
    }


}
