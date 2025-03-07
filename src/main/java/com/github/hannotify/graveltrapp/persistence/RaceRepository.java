package com.github.hannotify.graveltrapp.persistence;

import com.github.hannotify.graveltrapp.persistence.entities.Race;
import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class RaceRepository extends Repository<Race, UUID> {
    @Override
    protected Class<Race> entityClass() {
        return Race.class;
    }
}
