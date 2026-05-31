package com.SmartMaps.Smart.Route.Planner.service.Impl;

import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.client.GeoapifyClient;
import com.SmartMaps.Smart.Route.Planner.model.Coordinate;
import com.SmartMaps.Smart.Route.Planner.service.GeocodingService;

@Service
public class GeocodingServiceImpl implements GeocodingService {

	
	private final GeoapifyClient geoapifyClient;
	
	public GeocodingServiceImpl(
	        GeoapifyClient geoapifyClient) {

	    this.geoapifyClient = geoapifyClient;
	}



	@Override
	public Coordinate getCoordinates(String location) {

	    return geoapifyClient.fetchCoordinates(location);
	}

}
