package com.SmartMaps.Smart.Route.Planner.dto.osrm;

import java.util.List;

public class OsrmResponse {

    private List<RouteDto> routes;

    public List<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(
            List<RouteDto> routes) {

        this.routes = routes;
    }
}
