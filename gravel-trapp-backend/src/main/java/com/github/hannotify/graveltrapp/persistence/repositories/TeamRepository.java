package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.Team;
import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class TeamRepository extends Repository<Team, UUID> {
    @Override
    protected Class<Team> entityClass() {
        return Team.class;
    }
}
