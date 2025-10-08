package com.github.hannotify.graveltrapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "StandingsEntry", description = "A driver's position in the championship standings.")
public record StandingsEntry(
        @Schema @Min(1) @Max(20) int position,
        @Schema @NotEmpty String driverName,
        @Schema @NotEmpty String teamName,
        @Schema @Positive int points) {
}
