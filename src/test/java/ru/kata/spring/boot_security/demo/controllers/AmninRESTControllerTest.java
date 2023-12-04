package ru.kata.spring.boot_security.demo.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.init.MapperUser;
import ru.kata.spring.boot_security.demo.init.UserMapper;
import ru.kata.spring.boot_security.demo.services.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//@ExtendWith(MockitoExtension.class)
class AmninRESTControllerTest {

    String NAME = "Bob";

        @Mock
     UserMapper userMapper;
//    @Mock
//    MapperUser userMapper;

    @Mock
    UserService userService;

    @InjectMocks
    AmninRESTController amninRESTController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
//    @DisplayName("Выдает UserDTO  - на основе передfной String name ищет User в репозитории затем онпередаеться в мапер и результат в виде ДТО ввозвращаеться")
    void getUserByName() {

         User user = mock(User.class);
        when(userService.findByUsername(NAME)).thenReturn(user);
         UserDTO userDTO = mock(UserDTO.class);
        when(userMapper.userToUserDTO(user)).thenReturn(userDTO);


         UserDTO actual = amninRESTController.getUserByName(NAME);


        assertNotNull(actual);
        assertEquals(actual, userDTO);
        verify(userService.findByUsername(NAME));
//        verify(userMapper.userToUserDTO(any(User.class)));

    }

    @Test
    void saveUserNoRole() {




    }
}

//@ExtendWith(MockitoExtension.class)


//        User user = new User();
//        user.setUsername(NAME);
//verify(userMapper.userToUserDTO(user));

//        verify(userMapper.userToUserDTO(user));
//