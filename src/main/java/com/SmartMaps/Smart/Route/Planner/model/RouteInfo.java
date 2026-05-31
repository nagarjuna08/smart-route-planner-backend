package com.SmartMaps.Smart.Route.Planner.model;

import java.util.List;

public class RouteInfo 
{
    private Double totalDistance;

    private Double totalDuration;

    private String selectedAlgorithm;

    private List<Coordinate> routeCoordinates;

    private List<RouteSegment> segments;

	public Double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public Double getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Double totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getSelectedAlgorithm() {
		return selectedAlgorithm;
	}

	public void setSelectedAlgorithm(String selectedAlgorithm) {
		this.selectedAlgorithm = selectedAlgorithm;
	}

	public List<Coordinate> getRouteCoordinates() {
		return routeCoordinates;
	}

	public void setRouteCoordinates(List<Coordinate> routeCoordinates) {
		this.routeCoordinates = routeCoordinates;
	}

	public List<RouteSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<RouteSegment> segments) {
		this.segments = segments;
	}

	public RouteInfo(Double totalDistance, Double totalDuration, String selectedAlgorithm,
			List<Coordinate> routeCoordinates, List<RouteSegment> segments) {
		super();
		this.totalDistance = totalDistance;
		this.totalDuration = totalDuration;
		this.selectedAlgorithm = selectedAlgorithm;
		this.routeCoordinates = routeCoordinates;
		this.segments = segments;
	}

	public RouteInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
