package com.github.hannotify.graveltrapp.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "StandingsEntry", description = "A driver's position in the championship standings.")
public record StandingsEntry(
        @Schema(minimum = "1", maximum = "20") int position,
        @Schema String driverName,
        @Schema String teamName,
        @Schema(minimum = "0") int points) {
}
