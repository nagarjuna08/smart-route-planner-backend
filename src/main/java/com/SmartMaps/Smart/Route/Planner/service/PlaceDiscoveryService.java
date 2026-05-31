package com.SmartMaps.Smart.Route.Planner.service;

import java.util.List;

import com.SmartMaps.Smart.Route.Planner.dto.PlaceResponse;
import com.SmartMaps.Smart.Route.Planner.dto.PlaceSearchRequest;

public interface PlaceDiscoveryService 
{
    List<PlaceResponse> findPlacesAlongRoute(PlaceSearchRequest request);

    List<PlaceResponse> findTouristPlaces(PlaceSearchRequest request);

    List<PlaceResponse> findRestaurants(PlaceSearchRequest request);

    List<PlaceResponse> findHotels(PlaceSearchRequest request);

    List<PlaceResponse> findFuelStations(PlaceSearchRequest request);

    PlaceResponse getPlaceDetails(Long placeId);
}
