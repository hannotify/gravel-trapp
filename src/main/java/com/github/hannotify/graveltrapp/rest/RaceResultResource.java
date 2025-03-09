package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.RaceResultDto;
import com.github.hannotify.graveltrapp.persistence.beans.RaceResultMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceResultRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.UUID;

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

    @GET
    @Path("{raceId}")
    @Produces("application/json")
    public RaceResultDto getRaceResult(@PathParam("raceId") String raceId) {
        return raceResultRepository.findById(UUID.fromString(raceId))
                .map(raceResultMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Race result with id %s not found" .formatted(raceId)));
    }

    @POST
    @Consumes("application/json")
    public Response addRaceResult(RaceResultDto raceResultDto) {
        var raceResultEntity = raceResultMapper.toEntity(raceResultDto);
        raceResultRepository.create(raceResultEntity);
        return Response.created(URI.create(raceResultEntity.getId().toString())).build();
    }
}
