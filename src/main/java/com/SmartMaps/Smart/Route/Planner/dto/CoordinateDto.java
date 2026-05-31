package com.SmartMaps.Smart.Route.Planner.dto;

public class CoordinateDto 
{
    private Double latitude;

    private Double longitude;

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

	public CoordinateDto(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public CoordinateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
