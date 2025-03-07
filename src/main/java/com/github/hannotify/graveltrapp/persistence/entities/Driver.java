package com.github.hannotify.graveltrapp.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private int number;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "driver")
    private Set<RaceResult> raceResults = new HashSet<>();

    public Driver() {
    }

    public Driver(String name, Integer number, Team team) {
        this.name = name;
        this.number = number;
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<RaceResult> getRaceResults() {
        return raceResults;
    }
}
