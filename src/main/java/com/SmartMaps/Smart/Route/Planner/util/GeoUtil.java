package com.SmartMaps.Smart.Route.Planner.util;


import com.SmartMaps.Smart.Route.Planner.model.Coordinate;

public class GeoUtil {

    public static Coordinate midpoint(
            Coordinate source,
            Coordinate destination) {

        double lat =
                (source.getLatitude()
                        + destination.getLatitude())
                        / 2;

        double lon =
                (source.getLongitude()
                        + destination.getLongitude())
                        / 2;

        return new Coordinate(
                lat,
                lon);
    }

    public static boolean isValidCoordinate(
            Double latitude,
            Double longitude) {

        return latitude != null
                && longitude != null
                && latitude >= -90
                && latitude <= 90
                && longitude >= -180
                && longitude <= 180;
    }
}