package com.github.hannotify.graveltrapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "RaceResult", description = "The result of a race.")
public record RaceResultDto(
        @Schema @NotEmpty UUID raceId,
        @Schema @NotEmpty UUID driverId,
        @Schema @Min(1) @Max(20) int position,
        @Schema boolean fastestLap) {
}
