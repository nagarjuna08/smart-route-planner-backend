package com.SmartMaps.Smart.Route.Planner.dto.overpass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverpassTags {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(
            String name) {
        this.name = name;
    }
}