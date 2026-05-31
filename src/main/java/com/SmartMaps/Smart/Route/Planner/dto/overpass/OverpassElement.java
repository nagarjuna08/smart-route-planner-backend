package com.SmartMaps.Smart.Route.Planner.dto.overpass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverpassElement {

    private Long id;

    private Double lat;

    private Double lon;

    private OverpassTags tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public OverpassTags getTags() {
        return tags;
    }

    public void setTags(
            OverpassTags tags) {
        this.tags = tags;
    }
}