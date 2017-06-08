package com.michalkarmelita.bustimes.stops.model;

import com.michalkarmelita.bustimes.common.utils.Objects;

import java.util.Set;

public class StopData {

    private final String id;
    private final Double lat;
    private final Double lon;
    private final String indicator;
    private final String stopLetter;
    private final String commonName;
    private final Set<Integer> lines;

    public StopData(String id, Double lat, Double lon, String indicator, String stopLetter, String commonName, Set<Integer> lines) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.indicator = indicator;
        this.stopLetter = stopLetter;
        this.commonName = commonName;
        this.lines = lines;
    }

    public String getId() {
        return id;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getIndicator() {
        return indicator;
    }

    public String getStopLetter() {
        return stopLetter;
    }

    public String getCommonName() {
        return commonName;
    }

    public Set<Integer> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StopData stopData = (StopData) o;
        return Objects.equals(id, stopData.id);
    }
}
