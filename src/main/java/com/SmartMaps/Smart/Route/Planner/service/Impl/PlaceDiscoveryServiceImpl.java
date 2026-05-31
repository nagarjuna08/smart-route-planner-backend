package com.SmartMaps.Smart.Route.Planner.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.client.OverpassClient;
import com.SmartMaps.Smart.Route.Planner.dto.PlaceResponse;
import com.SmartMaps.Smart.Route.Planner.dto.PlaceSearchRequest;
import com.SmartMaps.Smart.Route.Planner.service.PlaceDiscoveryService;

@Service
public class PlaceDiscoveryServiceImpl implements PlaceDiscoveryService {

	
	private final OverpassClient overpassClient;
	

    public PlaceDiscoveryServiceImpl(OverpassClient overpassClient) {
		this.overpassClient = overpassClient;
	}

	@Override
    public List<PlaceResponse> findPlacesAlongRoute(PlaceSearchRequest request) {

        return overpassClient.fetchPlaces(request.getRouteCoordinates(),request.getCategory());
    }

    @Override
    public List<PlaceResponse> findTouristPlaces(PlaceSearchRequest request) {

        request.setCategory("TOURIST");

        return findPlacesAlongRoute(request);
    }

    @Override
    public List<PlaceResponse> findRestaurants(PlaceSearchRequest request) {

        request.setCategory("RESTAURANT");

        return findPlacesAlongRoute(request);
    }

    @Override
    public List<PlaceResponse> findHotels(PlaceSearchRequest request) {

        request.setCategory("HOTEL");

        return findPlacesAlongRoute(request);
    }

    @Override
    public List<PlaceResponse> findFuelStations(PlaceSearchRequest request) {

        request.setCategory("FUEL_STATION");

        return findPlacesAlongRoute(request);
    }

    @Override
    public PlaceResponse getPlaceDetails(Long placeId) {

        return overpassClient.fetchPlaceDetails(placeId);
    }
}
