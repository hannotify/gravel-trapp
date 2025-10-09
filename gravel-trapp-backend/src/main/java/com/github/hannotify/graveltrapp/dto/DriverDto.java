package com.github.hannotify.graveltrapp.dto;

import jakarta.validation.constraints.NotEmpty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Driver", description = "A driver that competes in a race.")
public record DriverDto(
        @Schema @NotEmpty UUID id,
        @Schema @NotEmpty String name,
        @Schema @NotEmpty String teamName) {
}
