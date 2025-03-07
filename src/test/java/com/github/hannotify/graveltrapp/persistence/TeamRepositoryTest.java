package com.github.hannotify.graveltrapp.persistence;

import com.github.hannotify.graveltrapp.persistence.entities.Driver;
import com.github.hannotify.graveltrapp.persistence.entities.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class TeamRepositoryTest extends RepositoryTest {
    private static Repository<Team, UUID> teamRepository;

    @BeforeAll
    static void beforeAll() {
        teamRepository = new TeamRepository().withEm(em);
    }

    @Test
    void testFindAll() {
        assertThat(teamRepository.findAll()).hasSize(3);
    }

    @Test
    void testCreate() {
        createTeamWithDrivers();
        assertThat(teamRepository.findAll()).hasSize(4);
    }

    @Test
    void testDelete() {
        var team = createTeam();
        assertThat(teamRepository.findAll()).hasSize(4);
        teamRepository.delete(team);
        assertThat(teamRepository.findAll()).hasSize(3);
    }

    @Test
    void testUpdate() {
        var anyTeam = teamRepository.findAll().stream().findAny().orElseGet(() -> fail("No teams found"));
        var newTeamName = "Williams F1 Team";

        anyTeam.setName(newTeamName);
        teamRepository.update(anyTeam);

        teamRepository.findById(anyTeam.getId()).ifPresentOrElse(
                updatedTeam -> assertThat(updatedTeam.getName()).isEqualTo(newTeamName),
                () -> fail("Team not found"));
    }

    private Team createTeam() {
        var team = new Team("McLaren F1 Team");

        teamRepository.create(team);

        return team;
    }

    private void createTeamWithDrivers() {
        var team = new Team("McLaren F1 Team");

        team.addDriver(new Driver("Lando Norris", 4, team));
        team.addDriver(new Driver("Oscar Piastri", 81, team));

        teamRepository.create(team);
    }
}