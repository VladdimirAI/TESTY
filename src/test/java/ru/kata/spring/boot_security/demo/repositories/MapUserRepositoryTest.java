package ru.kata.spring.boot_security.demo.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kata.spring.boot_security.demo.entities.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// можно было провеить еще одновременные доступы и чтения - было бы тогда этоинтегриционым тестированием ?
class MapUserRepositoryTest { // по факту проверка самого хранилища - чтоно сохраняет и достает результаты - в данном репозитории хранилище это мапа а в настоящем может быть же ибд - носкорее всего это не будет являться интеграционным тестом

    private static final Long ID = 4L;

    private MapUserRepository mapUserRepository;

    @BeforeEach
    public void setup() {
        mapUserRepository = new MapUserRepository();
    }


    // этот метот в ориге возвращает Юзера , а ниже метод нечего не возвращает
    @Test
    public void findById_vernutUsera_kogdaUserSushestvuet() { //по сути моск Юзер отличаеться лишь тем что у него мы можем возвращать в методезаранее прописанное значние - это по сути тоже самое тут  что - что у него мы задали только нужныенам поля для иквалса в данном случае поле ид
        final User userKotoruyMock = mock(User.class); //подготовь
        when(userKotoruyMock.getId()).thenReturn(ID);// в 23 строке мы создали потделку юзера(мок) - потому что у оригинала мы бы не смогли сделаь то что в 24 строке а именно заменили законстантили возврат у данного мока на зведомо известный нам 4L

        mapUserRepository.save(userKotoruyMock); //выполни
        final User userPolucenuyIzTestyruemogoMetoda = mapUserRepository.findById(ID); // строкой выше схраняем потделку  репозиторий , затем тут при помощи ТЕСТИРУЕМОГО метода достаем по итакоможе ид который использовался для создания поделки

        assertNotNull(userPolucenuyIzTestyruemogoMetoda);//проверь
        assertEquals(userKotoruyMock,userPolucenuyIzTestyruemogoMetoda);// строкой выше тестируем результат вызваногоТЕСТИРУЕМОГО метода что оне null , в этой строке сраввниваем резултат с тем что ложили в бд в данном случае в мапу - если б это была не мапа то был бы ентерационный тест
    }




    @Test
    public void saveUser_shouldSaveLastCalledUser_whenCalledMultipleTimes() { //ПЕРЕВОД saveUser должен сохранить последнего вызванного пользователя, когда вызывается несколько раз
       final User user = mock(User.class);
       when(user.getId()).thenReturn(ID);
       final User lastUser = mock(User.class);
       when(lastUser.getId()).thenReturn(ID);

       mapUserRepository.save(user);
       mapUserRepository.save(lastUser);
       final User actual = mapUserRepository.findById(ID);

       assertNotNull(actual);
       assertEquals(lastUser,actual); // по умолчаню иквалс у мокков тоже cамое что и ==

    }
}


// так тоже можно - но это неправильно!!

//    @Test
//    public void findById_vernutUsera_kogdaUserSushestvuet2() {
//        User user = new User(); // подготовь
//        user.setId(ID);
//
//        mapUserRepository.save(user); //выполни
//        final User userPolucenuyIzTestyruemogoMetoda = mapUserRepository.findById(ID);
//
//        assertNotNull(userPolucenuyIzTestyruemogoMetoda);//проверь
//        assertEquals(user,userPolucenuyIzTestyruemogoMetoda);//
//    }