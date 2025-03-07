package com.github.hannotify.graveltrapp.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class RaceResult {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Driver driver;

    @Column(nullable = false)
    private int position;

    @Column(nullable = false)
    private boolean fastestLap;

    public RaceResult() {
    }

    public RaceResult(Race race, Driver driver, int position, boolean fastestLap) {
        this.race = race;
        this.driver = driver;
        this.position = position;
        this.fastestLap = fastestLap;
    }

    public UUID getId() {
        return id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(boolean fastestLap) {
        this.fastestLap = fastestLap;
    }
}
