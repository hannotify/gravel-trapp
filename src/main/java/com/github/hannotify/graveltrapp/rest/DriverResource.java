package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.DriverDto;
import com.github.hannotify.graveltrapp.persistence.beans.DriverMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.DriverRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@RequestScoped
@Path("drivers")
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
    public List<DriverDto> getDrivers() {
        return driverRepository.findAll().stream()
                .map(driverMapper::toDto)
                .toList();
    }
}
