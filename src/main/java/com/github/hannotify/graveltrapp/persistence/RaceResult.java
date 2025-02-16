package com.github.hannotify.graveltrapp.persistence;

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
    private UUID raceResultId;

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
}
