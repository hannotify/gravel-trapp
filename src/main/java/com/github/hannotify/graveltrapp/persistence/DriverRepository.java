package com.github.hannotify.graveltrapp.persistence;

import com.github.hannotify.graveltrapp.persistence.entities.Driver;
import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class DriverRepository extends Repository<Driver, UUID> {
    @Override
    protected Class<Driver> entityClass() {
        return Driver.class;
    }
}
