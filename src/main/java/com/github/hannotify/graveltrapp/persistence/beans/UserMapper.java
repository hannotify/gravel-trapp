package com.github.hannotify.graveltrapp.persistence.beans;

import com.github.hannotify.graveltrapp.dto.UserDto;
import com.github.hannotify.graveltrapp.persistence.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {
    public static UserDto fromEntity(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getRoles());
    }

    public static User toEntity(UserDto userDto) {
        return new User(userDto.username(), userDto.password(), userDto.roles());
    }
}
