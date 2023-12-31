package ru.kata.spring.boot_security.demo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)///
class UserServiceImpTest {
    private static final long ID = 1L;
    private static final String NAME = "Bob";

    @Mock
    private UserRepository userRepository; // делает моку Репозитория

    @InjectMocks
    private UserServiceImp userService; // инжектит сюда эту моку  -- теструемый класс     --- это тоже становиться моком


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
//        when(userRepository.findById(Mockito.anyLong())).thenAnswer(invocation ->
//                {
//                    long id = invocation.<Long>getArgument(0);
//                    if (id<=0){
//                        throw new RuntimeException("Неверный формат ID");
//                    }
//                    return new User();
//                }
//
//                );


    }



    @Test
    @DisplayName("Проверяет поиск делегируеться ли логика в репозиторий")
    public void findUser_shouldCallRepository() { // а такое наименование(просто добаввление тест к реальному названию) помойму скажет майвену при сборке или дженкенсу запустить тест
        final User user = mock(User.class);
        when(userRepository.findByUsername(NAME)).thenReturn(user);

        final User actual = userService.findByUsername(NAME);

        assertNotNull(actual); //проверяем что выйдя из репозитория и подойдя к строке ретерн уже в серввисе юзер не стал нулем и не поменялся - по сути проверка нет ли между получением юзера путем делигироввания и стркой возврата ретерн - кода портюзего изменяющего нашего полученого юзера
        assertEquals(user, actual); //проверяем что выйдя из репозитория и подойдя к строке ретерн уже в серввисе юзер не стал нулем и не поменялся - по сути проверка нет ли между получением юзера путем делигироввания и стркой возврата ретерн - кода портюзего изменяющего нашего полученого юзера
        verify(userRepository).findByUsername(NAME);


    }

    @Test
    @DisplayName("Проверяет save делегируеться ли логика в репозиторий")
    public void saveUser_shouldCaltRepository() {
        final User user = mock(User.class);

        userService.save(user);

        verify(userRepository).save(user); // по сути проверяем произошло ли делигирование методу userRepository).save с аргументом user

    }

// прикол в том что так тоже работает не смотря на         when(userService.findByUsername(NAME)).thenReturn(user);
//    @Test
//    public void findUser_shouldCallRepository1() { // а такое наименование(просто добаввление тест к реальному названию) помойму скажет майвену при сборке или дженкенсу запустить тест
//        final User user = mock(User.class);
//        when(userService.findByUsername(NAME)).thenReturn(user);
//
//        final User actual = userService.findByUsername(NAME);
//
//        assertNotNull(actual);
//        assertEquals(user, actual);
//        verify(userRepository).findByUsername(NAME); //todo нифига не понимаю где у меня в тесте то вызывался один раз этот метод - ведь логика  была переопредела просто на возврат//выполняет проверку, что метод findByUsername(NAME) был вызван ровно один раз на моке userRepository с аргументом NAME.
//
//
//    }
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


