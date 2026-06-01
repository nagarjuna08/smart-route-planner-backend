package com.SmartMaps.Smart.Route.Planner.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SmartMaps.Smart.Route.Planner.model.Place;
import com.SmartMaps.Smart.Route.Planner.model.RouteInfo;
import com.SmartMaps.Smart.Route.Planner.service.RouteOptimizationService;
import com.SmartMaps.Smart.Route.Planner.service.RouteService;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

	private final RouteService routeService;

	public RouteOptimizationServiceImpl(RouteService routeService) {
		super();
		this.routeService = routeService;
	}

	@Override
	public RouteInfo optimizeRouteWithStop(RouteInfo route, Place selectedPlace) {

		RouteInfo optimizedRoute = new RouteInfo();

		optimizedRoute.setTotalDistance(route.getTotalDistance());

		optimizedRoute.setTotalDuration(route.getTotalDuration());

		return optimizedRoute;
	}

}
