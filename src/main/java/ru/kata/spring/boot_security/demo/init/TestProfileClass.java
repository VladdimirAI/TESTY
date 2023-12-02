package ru.kata.spring.boot_security.demo.init;



import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("test")
@Component
public class TestProfileClass { //Бин будет создан или нет в зависимости от профиля

    @PostConstruct
    public void init() {
        System.out.println("Бин создан в профиле  TEST");
    }


}