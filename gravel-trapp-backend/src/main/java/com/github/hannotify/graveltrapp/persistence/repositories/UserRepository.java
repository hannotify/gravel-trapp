package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.dto.UserDto;
import com.github.hannotify.graveltrapp.persistence.beans.UserMapper;
import com.github.hannotify.graveltrapp.persistence.entities.User;
import com.github.hannotify.graveltrapp.util.PasswordUtil;
import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class UserRepository extends Repository<User, UUID> {
    @Override
    protected Class<User> entityClass() {
        return User.class;
    }

    public UserDto findByUsernameAndPassword(String username, String password) {
        return UserMapper.fromEntity(em.createQuery(
                        """
                        SELECT u 
                        FROM User u 
                        WHERE u.username = :username AND u.password = :password
                        """, User.class)
                .setParameter("username", username)
                .setParameter("password", PasswordUtil.digest(password))
                .getSingleResult());
    }
}
