package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.persistence.beans.StandingsEntry;
import com.github.hannotify.graveltrapp.persistence.beans.StandingsProjector;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
    @Produces(MediaType.APPLICATION_JSON)
    public List<StandingsEntry> getStandings() {
        return standingsProjector.calculateStandings();
    }
}
