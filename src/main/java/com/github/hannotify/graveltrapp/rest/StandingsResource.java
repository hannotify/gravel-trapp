package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.persistence.projections.StandingsEntry;
import com.github.hannotify.graveltrapp.persistence.projections.StandingsProjector;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/standings")
public class StandingsResource {
    @Inject
    private StandingsProjector standingsProjector;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StandingsEntry> getStandings() {
        return standingsProjector.calculateStandings();
    }
}
