package com.SmartMaps.Smart.Route.Planner.dto;

import java.util.List;

public class RouteResponse 
{
    private Double totalDistance;

    private Double totalDuration;

    private String selectedAlgorithm;

    private Long nodesVisited;

    private Long executionTime;

    private List<CoordinateDto> coordinates;
    private List<String> itinerary;

    public List<String> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<String> itinerary) {
        this.itinerary = itinerary;
    }

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

	public Long getNodesVisited() {
		return nodesVisited;
	}

	public void setNodesVisited(Long nodesVisited) {
		this.nodesVisited = nodesVisited;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public List<CoordinateDto> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<CoordinateDto> coordinates) {
		this.coordinates = coordinates;
	}

    
    
}
