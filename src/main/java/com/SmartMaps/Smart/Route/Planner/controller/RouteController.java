package com.SmartMaps.Smart.Route.Planner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SmartMaps.Smart.Route.Planner.dto.RecalculateRouteRequest;
import com.SmartMaps.Smart.Route.Planner.dto.RouteRequest;
import com.SmartMaps.Smart.Route.Planner.dto.RouteResponse;
import com.SmartMaps.Smart.Route.Planner.service.RouteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "*")
public class RouteController 
{
	private final RouteService routeService;
	
	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}

	@PostMapping("/find")
	public ResponseEntity<RouteResponse> findRoute(@Valid @RequestBody RouteRequest request)
	{
		return ResponseEntity.ok(routeService.findBestRoute(request));
	}
	
    @PostMapping("/addStop")
    public ResponseEntity<RouteResponse> addStop(@Valid @RequestBody RecalculateRouteRequest request) {

        return ResponseEntity.ok(routeService.addStopAndOptimize(request));
    }
    
    @PostMapping("/summary")
    public ResponseEntity<RouteResponse> routeSummary(@Valid @RequestBody RouteRequest request) {

        return ResponseEntity.ok(routeService.getRouteSummary(request));
    }
}
