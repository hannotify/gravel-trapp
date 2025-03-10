package com.github.hannotify.graveltrapp.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Race", description = "A race that is part of the championship.")
public record RaceDto(
        @Schema UUID id,
        @Schema String name,
        @Schema short raceYear) {
}
