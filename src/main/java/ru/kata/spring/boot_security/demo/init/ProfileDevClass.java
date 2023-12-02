package ru.kata.spring.boot_security.demo.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class ProfileDevClass { //Бин будет создан или нет в зависимости от профиля

    @PostConstruct
    public void init() {
        System.out.println("Бин создан  в профиле DEV");
    }


}

