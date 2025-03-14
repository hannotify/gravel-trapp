package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.DriverDto;
import com.github.hannotify.graveltrapp.persistence.beans.DriverMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.DriverRepository;
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
@Path("drivers")
@PermitAll
public class DriverResource {
    private DriverRepository driverRepository;
    private DriverMapper driverMapper;

    // CDI needs a no-args constructor
    DriverResource() {}

    @Inject
    public DriverResource(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @GET
    @Produces("application/json")
    @APIResponse(
            responseCode = "200",
            description = "The list of drivers.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(type = SchemaType.ARRAY, implementation = DriverDto.class)))
    @Operation(
            summary = "Gets the full list of drivers.",
            description = "Retrieves and returns the list of drivers.")
    public List<DriverDto> getDrivers() {
        return driverRepository.findAll().stream()
                .map(driverMapper::toDto)
                .toList();
    }
}
