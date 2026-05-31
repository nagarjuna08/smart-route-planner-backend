package com.SmartMaps.Smart.Route.Planner.dto.osrm;

import java.util.List;

public class GeometryDto {

    private List<List<Double>> coordinates;

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(
            List<List<Double>> coordinates) {

        this.coordinates = coordinates;
    }
}
