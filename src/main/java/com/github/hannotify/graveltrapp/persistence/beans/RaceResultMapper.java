package com.github.hannotify.graveltrapp.persistence.beans;

import com.github.hannotify.graveltrapp.dto.RaceResultDto;
import com.github.hannotify.graveltrapp.persistence.entities.RaceResult;
import com.github.hannotify.graveltrapp.persistence.repositories.DriverRepository;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

@RequestScoped
public class RaceResultMapper {
    private RaceRepository raceRepository;
    private DriverRepository driverRepository;

    // CDI needs a no-args constructor
    RaceResultMapper() {}

    @Inject
    public RaceResultMapper(RaceRepository raceRepository, DriverRepository driverRepository) {
        this.raceRepository = raceRepository;
        this.driverRepository = driverRepository;
    }

    public RaceResult toEntity(RaceResultDto dto) {
        var race = raceRepository.findById(dto.raceId())
                .orElseThrow(() -> new EntityNotFoundException("Race with id %s not found".formatted(dto.raceId())));
        var driver = driverRepository.findById(dto.driverId())
                .orElseThrow(() -> new EntityNotFoundException("Driver with id %s not found".formatted(dto.driverId())));

        return new RaceResult(race, driver, dto.position(), dto.fastestLap());
    }
}
