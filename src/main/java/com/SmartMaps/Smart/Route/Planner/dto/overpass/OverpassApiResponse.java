package com.SmartMaps.Smart.Route.Planner.dto.overpass;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OverpassApiResponse {

    private List<OverpassElement> elements;

    public List<OverpassElement> getElements() {
        return elements;
    }

    public void setElements(
            List<OverpassElement> elements) {
        this.elements = elements;
    }
}