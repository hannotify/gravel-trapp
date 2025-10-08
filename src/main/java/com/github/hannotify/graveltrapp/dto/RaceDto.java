package com.github.hannotify.graveltrapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Race", description = "A race that's a part of the championship.")
public record RaceDto(
        @Schema @NotEmpty UUID id,
        @Schema @NotEmpty String name,
        @Schema @Positive short raceYear) {
}
