package com.SmartMaps.Smart.Route.Planner.service;

import com.SmartMaps.Smart.Route.Planner.model.Place;
import com.SmartMaps.Smart.Route.Planner.model.RouteInfo;

public interface RouteOptimizationService 
{
    RouteInfo optimizeRouteWithStop(RouteInfo route,Place selectedPlace);
}
