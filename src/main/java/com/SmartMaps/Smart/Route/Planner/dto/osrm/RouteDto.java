package com.SmartMaps.Smart.Route.Planner.dto.osrm;

public class RouteDto {

    private GeometryDto geometry;
    private Double distance;
    private Double duration;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public GeometryDto getGeometry() {
        return geometry;
    }

    public void setGeometry(
            GeometryDto geometry) {

        this.geometry = geometry;
    }
}