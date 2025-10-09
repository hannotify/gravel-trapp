package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.User;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository(dataStore = "jdbc/graveltrapp")
@Transactional
public interface UserRepository extends CrudRepository<User, UUID> {
    @Find
    Optional<User> findByUsernameAndPassword(String username, String password);
}
