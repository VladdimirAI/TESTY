package ru.kata.spring.boot_security.demo.init;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.entities.User;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
