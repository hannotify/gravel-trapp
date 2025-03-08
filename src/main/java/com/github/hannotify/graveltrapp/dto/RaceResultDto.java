package com.github.hannotify.graveltrapp.dto;

import java.util.UUID;

public record RaceResultDto(UUID raceId, UUID driverId, int position, boolean fastestLap) {
}
