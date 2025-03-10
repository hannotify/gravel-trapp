package com.github.hannotify.graveltrapp.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "RaceResult", description = "The result of a race.")
public record RaceResultDto(
        @Schema(required = true) UUID raceId,
        @Schema(required = true) UUID driverId,
        @Schema(required = true, minimum = "1", maximum = "20") int position,
        @Schema(required = true) boolean fastestLap) {
}
