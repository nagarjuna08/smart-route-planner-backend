package com.SmartMaps.Smart.Route.Planner.dto;

public class PlaceResponse 
{
	private Long placeId;

    private String name;

    private String category;

    private Double latitude;

    private Double longitude;

    private Double rating;

    private Double extraDistance;

    private Double extraTime;

    private boolean recommended;


	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getExtraDistance() {
		return extraDistance;
	}

	public void setExtraDistance(Double extraDistance) {
		this.extraDistance = extraDistance;
	}

	public Double getExtraTime() {
		return extraTime;
	}

	public void setExtraTime(Double extraTime) {
		this.extraTime = extraTime;
	}

	public boolean isRecommended() {
		return recommended;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	public PlaceResponse(Long placeId, String name, String category, Double latitude, Double longitude, Double rating,
			Double extraDistance, Double extraTime, boolean recommended) {
		super();
		this.placeId = placeId;
		this.name = name;
		this.category = category;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.extraDistance = extraDistance;
		this.extraTime = extraTime;
		this.recommended = recommended;
	}

	public PlaceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
