package com.SmartMaps.Smart.Route.Planner.dto;

import java.util.List;

public class PlaceSearchRequest 
{
	private List<CoordinateDto> routeCoordinates;

    private String category;

	public List<CoordinateDto> getRouteCoordinates() {
		return routeCoordinates;
	}

	public void setRouteCoordinates(List<CoordinateDto> routeCoordinates) {
		this.routeCoordinates = routeCoordinates;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public PlaceSearchRequest(List<CoordinateDto> routeCoordinates, String category) {
		super();
		this.routeCoordinates = routeCoordinates;
		this.category = category;
	}

	public PlaceSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
