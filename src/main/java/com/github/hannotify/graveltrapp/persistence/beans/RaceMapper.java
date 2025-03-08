package com.github.hannotify.graveltrapp.persistence.beans;

import com.github.hannotify.graveltrapp.dto.RaceDto;
import com.github.hannotify.graveltrapp.persistence.entities.Race;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RaceMapper {
    public RaceDto toDto(Race entity) {
        return new RaceDto(entity.getId(), entity.getName(), (short) entity.getRaceYear().getValue());
    }
}
