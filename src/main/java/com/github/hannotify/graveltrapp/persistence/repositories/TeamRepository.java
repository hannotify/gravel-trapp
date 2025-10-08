package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.Team;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;

import java.util.UUID;

@Repository(dataStore = "jdbc/graveltrapp")
@Transactional
public interface TeamRepository extends CrudRepository<Team, UUID> {
}
