package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.RaceDto;
import com.github.hannotify.graveltrapp.persistence.beans.RaceMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@RequestScoped
@Path("races")
public class RaceResource {
    private RaceRepository raceRepository;
    private RaceMapper raceMapper;

    // CDI needs a no-args constructor
    RaceResource() {}

    @Inject
    public RaceResource(RaceRepository raceRepository, RaceMapper raceMapper) {
        this.raceRepository = raceRepository;
        this.raceMapper = raceMapper;
    }

    @GET
    @Produces("application/json")
    public List<RaceDto> getRaces() {
        return raceRepository.findAll().stream()
                .map(raceMapper::toDto)
                .toList();
    }
}

