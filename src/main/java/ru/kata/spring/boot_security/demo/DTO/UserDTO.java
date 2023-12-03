package ru.kata.spring.boot_security.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    // Вы можете включить другие поля, которые считаете нужными

    // Конструкторы, геттеры и сеттеры
    public UserDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Методы equals и hashCode, если нужны


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getId().equals(userDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
