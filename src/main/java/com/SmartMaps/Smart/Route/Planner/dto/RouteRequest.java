package com.SmartMaps.Smart.Route.Planner.dto;

import jakarta.validation.constraints.NotBlank;

public class RouteRequest 
{
    @NotBlank(message = "Start location is required")
    private String startLocation;

    @NotBlank(message = "Destination location is required")
    private String destinationLocation;

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public RouteRequest(@NotBlank String startLocation, @NotBlank String destinationLocation) {
		super();
		this.startLocation = startLocation;
		this.destinationLocation = destinationLocation;
	}

	public RouteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
