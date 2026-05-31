package com.SmartMaps.Smart.Route.Planner.dto;

public class RouteSummaryResponse 
{
	private Double distance;

    private Double duration;

    private Integer numberOfStops;

    private String selectedAlgorithm;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(Integer numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

	public String getSelectedAlgorithm() {
		return selectedAlgorithm;
	}

	public void setSelectedAlgorithm(String selectedAlgorithm) {
		this.selectedAlgorithm = selectedAlgorithm;
	}

	public RouteSummaryResponse(Double distance, Double duration, Integer numberOfStops, String selectedAlgorithm) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.numberOfStops = numberOfStops;
		this.selectedAlgorithm = selectedAlgorithm;
	}

	public RouteSummaryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
