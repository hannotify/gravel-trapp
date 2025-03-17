package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.RaceResult;
import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class RaceResultRepository extends Repository<RaceResult, UUID> {
    @Override
    protected Class<RaceResult> entityClass() {
        return RaceResult.class;
    }
}
