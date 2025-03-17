package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.RaceDto;
import com.github.hannotify.graveltrapp.persistence.beans.RaceMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceRepository;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@RequestScoped
@Path("races")
@PermitAll
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
    @APIResponse(
            responseCode = "200",
            description = "The list of races.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(type = SchemaType.ARRAY, implementation = RaceDto.class)))
    @Operation(
            summary = "Gets the full list of races.",
            description = "Retrieves and returns the list of races.")
    public List<RaceDto> getRaces() {
        return raceRepository.findAll().stream()
                .map(raceMapper::toDto)
                .toList();
    }
}

