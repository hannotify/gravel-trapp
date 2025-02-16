package com.github.hannotify.graveltrapp.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Race {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Year year;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RaceType raceType;

    @OneToMany(mappedBy = "race")
    private Set<RaceResult> raceResults = new HashSet<>();

    public Race() {
    }

    public Race(String name, Year year, RaceType raceType) {
        this.name = name;
        this.year = year;
        this.raceType = raceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public Set<RaceResult> getRaceResults() {
        return raceResults;
    }
}
