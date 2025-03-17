package com.github.hannotify.graveltrapp.persistence.beans;

import com.github.hannotify.graveltrapp.dto.StandingsEntry;
import com.github.hannotify.graveltrapp.persistence.entities.Driver;
import com.github.hannotify.graveltrapp.persistence.entities.RaceResult;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceResultRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.InternalServerErrorException;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.reverseOrder;
import static java.util.Map.entry;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RequestScoped
public class StandingsProjector {
    private RaceResultRepository raceResultRepository;
    private List<StandingsEntry> cachedStandings;

    private static final int POINTS_FOR_FASTEST_LAP = 1;
    private static final Map<Integer, Integer> POINT_SYSTEM = Map.ofEntries(
            entry(1, 25),
            entry(2, 18),
            entry(3, 15),
            entry(4, 12),
            entry(5, 10),
            entry(6, 8),
            entry(7, 6),
            entry(8, 4),
            entry(9, 2),
            entry(10, 1),
            entry(11, 0),
            entry(12, 0),
            entry(13, 0),
            entry(14, 0),
            entry(15, 0),
            entry(16, 0),
            entry(17, 0),
            entry(18, 0),
            entry(19, 0),
            entry(20, 0));

    // CDI needs a no-args constructor
    StandingsProjector() {}

    @Inject
    public StandingsProjector(RaceResultRepository raceResultRepository) {
        this.raceResultRepository = raceResultRepository;
    }

    @Timeout(2000)
    @Fallback(fallbackMethod = "fallbackForCalculateStandings")
    public List<StandingsEntry> calculateStandings() {
        Map<Driver, Integer> raceResults = raceResultRepository.findAll().stream()
                .collect(groupingBy(
                        RaceResult::getDriver,
                        collectingAndThen(
                                toList(),
                                results -> results.stream()
                                        .mapToInt(result -> calculatePoints(result.getPosition(), result.isFastestLap()))
                                        .sum())
                ));

        var sortedRaceResults = raceResults.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .toList();

        List<StandingsEntry> standings = new ArrayList<>();

        for (int i = 0; i < sortedRaceResults.size(); i++) {
            var entry = sortedRaceResults.get(i);
            var driver = entry.getKey();
            var driverName = driver.getName();
            var teamName = driver.getTeam().getName();
            var points = entry.getValue();
            var position = i + 1;

            standings.add(new StandingsEntry(position, driverName, teamName, points));
        }

        cachedStandings = standings;
        return standings;
    }

    private List<StandingsEntry> fallbackForCalculateStandings() {
        if (cachedStandings == null) {
            throw new InternalServerErrorException("The championship standings are not available.");
        }

        return cachedStandings;
    }

    private int calculatePoints(int position, boolean fastestLap) {
        return POINT_SYSTEM.get(position) + (position <= 10 && fastestLap ? POINTS_FOR_FASTEST_LAP : 0);
    }
}
