package com.github.hannotify.graveltrapp.persistence.repositories;

import com.github.hannotify.graveltrapp.persistence.entities.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class DriverRepositoryTest extends RepositoryTest {
    private static Repository<Driver, UUID> driverRepository;

    @BeforeAll
    static void beforeAll() {
        driverRepository = new DriverRepository().withEm(em);
    }

    @Test
    void testFindAll() {
        assertThat(driverRepository.findAll()).hasSize(6);
    }

    @Test
    void testCreate() {
        createDriverForAnyTeam();
        assertThat(driverRepository.findAll()).hasSize(7);
    }

    @Test
    void testDelete() {
        var driver = createDriverForAnyTeam();
        assertThat(driverRepository.findAll()).hasSize(7);
        driverRepository.delete(driver);
        assertThat(driverRepository.findAll()).hasSize(6);
    }

    @Test
    void testUpdate() {
        var driver = driverRepository.findAll().stream().findAny().orElseGet(() -> fail("No drivers found"));
        var newDriverName = "Sophia Flörsch";

        driver.setName(newDriverName);
        driverRepository.update(driver);

        driverRepository.findById(driver.getId()).ifPresentOrElse(
                updatedDriver -> assertThat(updatedDriver.getName()).isEqualTo(newDriverName),
                () -> fail("Driver not found"));
    }

    private Driver createDriverForAnyTeam() {
        var teamRepository = new TeamRepository().withEm(em);
        var team = teamRepository.findAll().stream().findAny().orElseGet(() -> fail("No teams found"));
        var driver = new Driver("Daniel Ricciardo", 3, team);
        driverRepository.create(driver);
        return driver;
    }
}
