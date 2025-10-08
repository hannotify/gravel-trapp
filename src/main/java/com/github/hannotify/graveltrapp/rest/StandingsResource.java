package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.StandingsEntry;
import com.github.hannotify.graveltrapp.persistence.beans.StandingsProjector;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/standings")
public class StandingsResource {
    private StandingsProjector standingsProjector;

    // CDI needs a no-args constructor
    StandingsResource() {}

    @Inject
    public StandingsResource(StandingsProjector standingsProjector) {
        this.standingsProjector = standingsProjector;
    }

    @GET
    public List<StandingsEntry> getStandings() {
        return standingsProjector.calculateStandings();
    }
}
