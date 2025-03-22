package com.github.hannotify.graveltrapp.persistence.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
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
    @Convert(converter = YearAttributeConverter.class)
    private Year raceYear;

    @OneToMany(mappedBy = "race")
    private Set<RaceResult> raceResults = new HashSet<>();

    public Race() {
    }

    public Race(String name, Year raceYear) {
        this.name = name;
        this.raceYear = raceYear;
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

    public Year getRaceYear() {
        return raceYear;
    }

    public void setRaceYear(Year year) {
        this.raceYear = year;
    }

    public Set<RaceResult> getRaceResults() {
        return raceResults;
    }

    @Converter
    public static class YearAttributeConverter implements AttributeConverter<Year, Short> {
        @Override
        public Short convertToDatabaseColumn(Year attribute) {
            return attribute != null ? (short) attribute.getValue() : null;
        }

        @Override
        public Year convertToEntityAttribute(Short dbData) {
            return dbData != null ? Year.of(dbData) : null;
        }
    }
}
