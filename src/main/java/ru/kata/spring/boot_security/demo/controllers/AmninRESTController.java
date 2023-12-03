package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.init.UserMapper;
import ru.kata.spring.boot_security.demo.services.UserService;

@RestController
@RequestMapping("/tests")
public class AmninRESTController {

    private UserService userService;
    private UserMapper userMapper; // Убираем аннотацию Autowired и final не нужен


    public AmninRESTController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public UserDTO getUserByName(@PathVariable("name") String userName) {
        final User user = userService.findByUsername(userName);
        return userMapper.userToUserDTO(user);
    }


    @PutMapping()
    public void saveUserNoRole(@RequestBody @Validated UserDTO userDTO) {
        final User user = userMapper.userDTOToUser(userDTO);
        userService.save(user);
    }


}
