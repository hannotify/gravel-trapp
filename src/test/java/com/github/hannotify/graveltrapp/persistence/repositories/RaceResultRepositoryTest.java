package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.RaceResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RaceResultRepositoryTest extends RepositoryTest {
    private static Repository<RaceResult, UUID> raceResultRepository;

    @BeforeAll
    static void beforeAll() {
        raceResultRepository = new RaceResultRepository().withEm(em);
    }

    @Test
    void testFindAll() {
        assertThat(raceResultRepository.findAll()).hasSize(3);
    }

    @Test
    void testCreate() {
        createRaceResultForAnyDriverAnyRace();
        assertThat(raceResultRepository.findAll()).hasSize(4);
    }

    @Test
    void testDelete() {
        var raceResult = createRaceResultForAnyDriverAnyRace();
        assertThat(raceResultRepository.findAll()).hasSize(4);

        raceResultRepository.delete(raceResult);

        assertThat(raceResultRepository.findAll()).hasSize(3);
    }

    @Test
    void testUpdate() {
        var anyRaceResult = raceResultRepository.findAll().stream().findAny().orElseGet(() -> fail("No race results found"));
        var oldPosition = anyRaceResult.getPosition();
        var newPosition = 4;

        assertThat(oldPosition).isNotEqualTo(newPosition);

        anyRaceResult.setPosition(newPosition);
        raceResultRepository.update(anyRaceResult);

        raceResultRepository.findById(anyRaceResult.getId()).ifPresentOrElse(
                updatedRaceResult -> assertThat(updatedRaceResult.getPosition()).isEqualTo(newPosition),
                () -> fail("Race result not found"));
    }

    private RaceResult createRaceResultForAnyDriverAnyRace() {
        var raceRepository = new RaceRepository().withEm(em);
        var driverRepository = new DriverRepository().withEm(em);

        var anyRace = raceRepository.findAll().stream().findAny().orElseGet(() -> fail("No races found"));
        var anyDriver = driverRepository.findAll().stream().findAny().orElseGet(() -> fail("No drivers found"));

        var raceResult = new RaceResult(anyRace, anyDriver, 1, true);
        raceResultRepository.create(raceResult);
        return raceResult;
    }
}
