package com.SmartMaps.Smart.Route.Planner.service;

import com.SmartMaps.Smart.Route.Planner.dto.RecalculateRouteRequest;
import com.SmartMaps.Smart.Route.Planner.dto.RouteRequest;
import com.SmartMaps.Smart.Route.Planner.dto.RouteResponse;

public interface RouteService 
{
    RouteResponse findBestRoute(RouteRequest request);

    RouteResponse addStopAndOptimize(RecalculateRouteRequest request);

    RouteResponse getRouteSummary(RouteRequest request);

}
