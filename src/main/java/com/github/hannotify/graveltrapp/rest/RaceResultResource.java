package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.RaceResultDto;
import com.github.hannotify.graveltrapp.persistence.beans.RaceResultMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceResultRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("race-results")
public class RaceResultResource {
    private RaceResultRepository raceResultRepository;
    private RaceResultMapper raceResultMapper;

    // CDI needs a no-args constructor
    RaceResultResource() {}

    @Inject
    public RaceResultResource(RaceResultRepository raceResultRepository, RaceResultMapper raceResultMapper) {
        this.raceResultRepository = raceResultRepository;
        this.raceResultMapper = raceResultMapper;
    }

    @POST
    @Consumes("application/json")
    public void addRaceResult(RaceResultDto raceResultDto) {
        var raceResultEntity = raceResultMapper.toEntity(raceResultDto);
        raceResultRepository.create(raceResultEntity);
    }
}
