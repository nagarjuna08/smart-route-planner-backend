package com.SmartMaps.Smart.Route.Planner.service;

import com.SmartMaps.Smart.Route.Planner.model.Coordinate;

public interface GeocodingService 
{
    Coordinate getCoordinates(String location);
}
