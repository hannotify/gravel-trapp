package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.Race;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.UUID;

class RaceRepositoryTest extends RepositoryTest {
    private static Repository<Race, UUID> raceRepository;

    @BeforeAll
    static void beforeAll() {
        raceRepository = new RaceRepository().withEm(em);
    }

    @Test
    void testFindAll() {
        assertThat(raceRepository.findAll()).hasSize(2);
    }

    @Test
    void testCreate() {
        createRace();
        assertThat(raceRepository.findAll()).hasSize(3);
    }

    @Test
    void testDelete() {
        var race = createRace();
        assertThat(raceRepository.findAll()).hasSize(3);
        raceRepository.delete(race);
        assertThat(raceRepository.findAll()).hasSize(2);
    }

    @Test
    void testUpdate() {
        var race = raceRepository.findAll().stream().findAny().orElseGet(() -> fail("No races found"));
        var newRaceYear = race.getRaceYear().plusYears(1);

        race.setRaceYear(newRaceYear);
        raceRepository.update(race);

        raceRepository.findById(race.getId()).ifPresentOrElse(
                updatedRace -> assertThat(updatedRace.getRaceYear()).isEqualTo(newRaceYear),
                () -> fail("Race not found"));
    }

    private Race createRace() {
        var race = new Race("Monaco Grand Prix", Year.of(2025));
        raceRepository.create(race);
        return race;
    }
}