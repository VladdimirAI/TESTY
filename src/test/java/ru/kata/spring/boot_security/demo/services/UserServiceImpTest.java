package ru.kata.spring.boot_security.demo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UserServiceImp userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void findByUsernameTest() {
        String username = "testUser";
        User mockUser = new User();
        mockUser.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(mockUser);

        User user = userService.findByUsername(username);

        assertEquals(username, user.getUsername());
        verify(userRepository).findByUsername(username);
    }





}

//
//@Test
//
//Это аннотация JUnit, которая указывает, что метод является тестовым методом.
//        String username = "testUser";
//
//        Создается строковая переменная username и инициализируется значением "testUser". Это имя пользователя, которое мы будем использовать в тесте.
//        User mockUser = new User();
//
//        Создается новый экземпляр User, который будет использоваться как имитация (mock) возвращаемого значения.
//        mockUser.setUsername(username);
//
//        Устанавливаем имя пользователя mockUser как "testUser", то есть значение переменной username.
//        when(userRepository.findByUsername(username)).thenReturn(mockUser);
//
//        Используя Mockito, настраиваем поведение мока userRepository. Метод findByUsername при вызове с аргументом "testUser" должен вернуть mockUser. Это означает, что когда в тесте будет вызван userRepository.findByUsername("testUser"), он вернет mockUser.
//        User user = userService.findByUsername(username);
//
//        Вызываем метод findByUsername у userService с аргументом "testUser". В реальности, этот вызов приведет к вызову userRepository.findByUsername("testUser"), который, как мы настроили ранее, вернет mockUser.
//        assertEquals(username, user.getUsername());
//
//        Проверяем, совпадает ли имя пользователя в возвращенном объекте user с ожидаемым значением "testUser". Это основная проверка теста: убедиться, что метод findByUsername возвращает пользователя с правильным именем пользователя.
//        verify(userRepository).findByUsername(username);
//
//        Проверяем, был ли вызван метод findByUsername с аргументом "testUser" на моке userRepository. Это убедителен, что взаимодействие с репозиторием происходит, как ожидалось.


