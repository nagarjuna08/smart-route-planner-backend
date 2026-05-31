package com.SmartMaps.Smart.Route.Planner.model.graph;

public class Node 
{
    private Long id;

    private Double latitude;

    private Double longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Node(Long id, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
