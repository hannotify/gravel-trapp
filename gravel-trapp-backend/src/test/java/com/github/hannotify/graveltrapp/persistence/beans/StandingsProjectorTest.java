package com.github.hannotify.graveltrapp.persistence.beans;

import com.github.hannotify.graveltrapp.dto.StandingsEntry;
import com.github.hannotify.graveltrapp.persistence.entities.Driver;
import com.github.hannotify.graveltrapp.persistence.entities.Race;
import com.github.hannotify.graveltrapp.persistence.entities.RaceResult;
import com.github.hannotify.graveltrapp.persistence.entities.Team;
import com.github.hannotify.graveltrapp.persistence.repositories.RaceResultRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Year;
import java.util.List;
import java.util.SequencedCollection;

import static org.assertj.core.api.Assertions.assertThat;

class StandingsProjectorTest {
    @Test
    void testCalculateStandings() {
        var raceResultRepository = Mockito.mock(RaceResultRepository.class);
        Mockito.when(raceResultRepository.findAll()).thenReturn(mockRaceResults());

        var standingsProjector = new StandingsProjector(raceResultRepository);
        var expectedStandings = List.of(
                new StandingsEntry(1, "Max Verstappen", "Red Bull Racing", 25),
                new StandingsEntry(2, "Lewis Hamilton", "Mercedes", 19),
                new StandingsEntry(3, "Sergio Perez", "Red Bull Racing", 15),
                new StandingsEntry(4, "Lando Norris", "McLaren", 12),
                new StandingsEntry(5, "Carlos Sainz", "Ferrari", 10),
                new StandingsEntry(6, "George Russell", "Mercedes", 8),
                new StandingsEntry(7, "Charles Leclerc", "Ferrari", 6),
                new StandingsEntry(8, "Oscar Piastri", "McLaren", 4),
                new StandingsEntry(9, "Fernando Alonso", "Aston Martin", 2),
                new StandingsEntry(10, "Lance Stroll", "Aston Martin", 1)
        );

        var actualStandings = standingsProjector.calculateStandings();

        assertThat(actualStandings).isEqualTo(expectedStandings);
    }

    private SequencedCollection<RaceResult> mockRaceResults() {
        var monacoGrandPrix = new Race("Monaco Grand Prix", Year.of(2021));

        var redBullRacing = new Team("Red Bull Racing");
        var mercedes = new Team("Mercedes");
        var ferrari = new Team("Ferrari");
        var mcLaren = new Team("McLaren");
        var astonMartin = new Team("Aston Martin");

        var maxVerstappen = new Driver("Max Verstappen", 33, redBullRacing);
        var sergioPerez = new Driver("Sergio Perez", 11, redBullRacing);
        var lewisHamilton = new Driver("Lewis Hamilton", 44, mercedes);
        var georgeRussell = new Driver("George Russell", 66, mercedes);
        var charlesLeclerc = new Driver("Charles Leclerc", 16, ferrari);
        var carlosSainz = new Driver("Carlos Sainz", 55, ferrari);
        var landoNorris = new Driver("Lando Norris", 4, mcLaren);
        var oscarPiastri = new Driver("Oscar Piastri", 31, mcLaren);
        var fernandoAlonso = new Driver("Fernando Alonso", 14, astonMartin);
        var lanceStroll = new Driver("Lance Stroll", 18, astonMartin);

        return List.of(
            new RaceResult(monacoGrandPrix, maxVerstappen, 1, false),
            new RaceResult(monacoGrandPrix, lewisHamilton, 2, true),
            new RaceResult(monacoGrandPrix, sergioPerez, 3, false),
            new RaceResult(monacoGrandPrix, landoNorris, 4, false),
            new RaceResult(monacoGrandPrix, carlosSainz, 5, false),
            new RaceResult(monacoGrandPrix, georgeRussell, 6, false),
            new RaceResult(monacoGrandPrix, charlesLeclerc, 7, false),
            new RaceResult(monacoGrandPrix, oscarPiastri, 8, false),
            new RaceResult(monacoGrandPrix, fernandoAlonso, 9, false),
            new RaceResult(monacoGrandPrix, lanceStroll, 10, false)
        );
    }
}