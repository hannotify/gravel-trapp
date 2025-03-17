package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.RaceResultDto;
import com.github.hannotify.graveltrapp.persistence.beans.RaceResultMapper;
import com.github.hannotify.graveltrapp.persistence.entities.RaceResult;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceResultRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

import java.net.URI;
import java.util.UUID;

@RequestScoped
@Path("race-results")
@PermitAll
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
    @APIResponseSchema(value = RaceResultDto.class,
            responseDescription = "A race result.",
            responseCode = "200")
    @APIResponse(
            responseCode = "404",
            description = "Race result not found.",
            content = @Content(mediaType = "application/json"))
    @Operation(
            summary = "Gets a specific race result.",
            description = "Retrieves and returns a specific race result.")
    public RaceResultDto getRaceResult(@PathParam("raceId") String raceId) {
        return raceResultRepository.findById(UUID.fromString(raceId))
                .map(raceResultMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Race result with id %s not found." .formatted(raceId)));
    }

    @POST
    @Consumes("application/json")
    @RolesAllowed("admin")
    @APIResponse(
            responseCode = "201",
            description = "Race result successfully created.")
    @APIResponse(
            responseCode = "400",
            description = "The race or driver that was supplied doesn't exist.")
    @Operation(
            summary = "Adds a race result.",
            description = "Adds a specific race result.")
    public Response addRaceResult(RaceResultDto raceResultDto) {
        RaceResult raceResultEntity;
        try {
            raceResultEntity = raceResultMapper.toEntity(raceResultDto);
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        raceResultRepository.create(raceResultEntity);
        return Response.created(URI.create(raceResultEntity.getId().toString())).build();
    }
}
