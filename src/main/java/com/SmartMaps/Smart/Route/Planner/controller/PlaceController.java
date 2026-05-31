package com.SmartMaps.Smart.Route.Planner.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SmartMaps.Smart.Route.Planner.dto.PlaceResponse;
import com.SmartMaps.Smart.Route.Planner.dto.PlaceSearchRequest;
import com.SmartMaps.Smart.Route.Planner.service.PlaceDiscoveryService;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "*")
public class PlaceController 
{
	private final PlaceDiscoveryService placeDiscoveryService;
	
	
	public PlaceController(PlaceDiscoveryService placeDiscoveryService) {
		super();
		this.placeDiscoveryService = placeDiscoveryService;
	}


	@PostMapping("/along-route")
    public ResponseEntity<List<PlaceResponse>> getPlacesAlongRoute(
            @RequestBody PlaceSearchRequest request) {

        return ResponseEntity.ok(
                placeDiscoveryService.findPlacesAlongRoute(request)
        );
    }
}

