package com.SmartMaps.Smart.Route.Planner.service.Impl;

import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.client.NominatimClient;
import com.SmartMaps.Smart.Route.Planner.model.Coordinate;
import com.SmartMaps.Smart.Route.Planner.service.GeocodingService;

@Service
public class GeocodingServiceImpl implements GeocodingService {

	private final NominatimClient nominatimClient;
	
	
	
	public GeocodingServiceImpl(NominatimClient nominatimClient) {
		super();
		this.nominatimClient = nominatimClient;
	}



	@Override
	public Coordinate getCoordinates(String location) {
		
//		if(location.equalsIgnoreCase("Hyderabad")) {
//	        return new Coordinate(
//	                17.3850,
//	                78.4867);
//	    }
//
//	    if(location.equalsIgnoreCase("Vijayawada")) {
//	        return new Coordinate(
//	                16.5062,
//	                80.6480);
//	    }
//
//	    return new Coordinate(
//	            17.3850,
//	            78.4867);
      return nominatimClient.fetchCoordinates(location);

		
	}

}
