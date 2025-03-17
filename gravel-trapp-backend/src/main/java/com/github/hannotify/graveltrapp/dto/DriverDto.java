package com.github.hannotify.graveltrapp.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.UUID;

@Schema(name = "Driver", description = "A driver that participates in a race.")
public record DriverDto(
        @Schema UUID id,
        @Schema String name,
        @Schema String teamName) {
}
