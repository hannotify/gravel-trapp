package com.github.hannotify.graveltrapp.persistence.beans;

import com.github.hannotify.graveltrapp.dto.DriverDto;
import com.github.hannotify.graveltrapp.persistence.entities.Driver;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriverMapper {
    public DriverDto toDto(Driver entity) {
        return new DriverDto(entity.getId(), entity.getName(), entity.getTeam().getName());
    }
}
