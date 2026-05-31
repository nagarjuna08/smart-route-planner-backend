package com.SmartMaps.Smart.Route.Planner.dto;

import jakarta.validation.constraints.NotBlank;

public class RecalculateRouteRequest 
{
	@NotBlank
    private String startLocation;

    @NotBlank
    private String destinationLocation;

    private String placeId;

    private Double latitude;

    private Double longitude;
    private String placeName;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
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

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public RecalculateRouteRequest(@NotBlank String startLocation, @NotBlank String destinationLocation, String placeId,
			Double latitude, Double longitude) {
		super();
		this.startLocation = startLocation;
		this.destinationLocation = destinationLocation;
		this.placeId = placeId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public RecalculateRouteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
