package ru.kata.spring.boot_security.demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.init.UserMapper;
import ru.kata.spring.boot_security.demo.services.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AmninRESTControllerTest {

    private final String  NAME = "Bob";

    @Mock
    private UserMapper userMapper;
    @Mock
    private UserService userService;

    @InjectMocks
    private AmninRESTController amninRESTController;

    @Test
    @DisplayName("Выдает UserDTO  - на основе передfной String name ищет User в репозитории затем онпередаеться в мапер и результат в виде ДТО ввозвращаеться")
    void getUserByName() {
        final User user = mock(User.class);
        when(userService.findByUsername(NAME)).thenReturn(user);
        final UserDTO userDTO = mock(UserDTO.class);
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);

        final UserDTO actual = amninRESTController.getUserByName(NAME);








    }

    @Test
    void saveUserNoRole() {
    }
}